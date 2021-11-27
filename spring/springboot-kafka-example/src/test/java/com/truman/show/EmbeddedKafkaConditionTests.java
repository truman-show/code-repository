package com.truman.show;


import static com.truman.show.EmbeddedKafkaConditionTests.STREAMING_TOPIC1;
import static com.truman.show.EmbeddedKafkaConditionTests.STREAMING_TOPIC2;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.kafka.test.assertj.KafkaConditions.key;
import static org.springframework.kafka.test.assertj.KafkaConditions.partition;
import static org.springframework.kafka.test.assertj.KafkaConditions.value;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.junit.jupiter.api.Test;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.kafka.test.EmbeddedKafkaBroker;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.kafka.test.utils.ContainerTestUtils;
import org.springframework.kafka.test.utils.KafkaTestUtils;
import org.springframework.test.annotation.DirtiesContext;

@DirtiesContext
@EmbeddedKafka(
    partitions = 1,
    topics = {
        STREAMING_TOPIC1,
        STREAMING_TOPIC2
    },
    bootstrapServersProperty = "spring.kafka.bootstrap-servers"
)
public class EmbeddedKafkaConditionTests {

  public static final String STREAMING_TOPIC1 = "com.truman.one";
  public static final String STREAMING_TOPIC2 = "com.truman.two";

  @Test
  public void test(EmbeddedKafkaBroker embeddedKafka) {
    System.out.println("embeddedKafka :" + embeddedKafka);
    String brokersAsString = embeddedKafka.getBrokersAsString();
    System.out.println(brokersAsString);
    System.out.println(embeddedKafka.getKafkaServers());
    Iterator<String> topics = embeddedKafka.getTopics().iterator();
    while (topics.hasNext()) {
      System.out.println(topics.next());
    }
  }

  // 테스트를 실행하기위해 kafka ConsumerFactory, ListenerContainer 객체를 생성해줘야한다.
  @Test
  public void testTemplate(EmbeddedKafkaBroker embeddedKafka) throws Exception {
    // KafkaTestUtils 는 AUTO_OFFSET_RESET_CONFIG 기본값으로 `earliest` 를 사용한다.
    // KafkaTestUtils 클래스는 프로듀서, 컨슈머 속성을 설정하는 몇가지 정적 메서드를 제공한다.

    // 1. 컨슈머에 대한 테스트 속성을 설정합니다.
    Map<String, Object> consumerProps = KafkaTestUtils.consumerProps(
        "myGroup", "false", embeddedKafka);

    // DefaultKafkaConsumerFactory 객체를 생성한다 (KafkaConsumerConfig 클래스의 consumerFactory 빈)
    DefaultKafkaConsumerFactory<Integer, String> defaultKafkaConsumerFactory
        = new DefaultKafkaConsumerFactory<>(consumerProps);

    // ContainerProperties  리스너 컨테이너의 런타임 속성을 포함합니다.
    ContainerProperties containerProperties = new ContainerProperties(STREAMING_TOPIC1);  //생성자 매개변수로 전달받은 토픽을 구독할 컨테이너에 대한 속성을 만듭니다.

    // KafkaMessageListenerContainer는 단일 스레드의 모든 주제 / 파티션에서 모든 메시지를 수신합니다.
    // ConcurrentMessageListenerContainer는 다중 스레드 소비를 제공하기 위해 1 개 이상의 KafkaMessageListenerContainer에 위임합니다.

    // KafkaMessageListenerContainer 컨테이너를 생성합니다.
    KafkaMessageListenerContainer<Integer, String> container =
        new KafkaMessageListenerContainer<>(defaultKafkaConsumerFactory, containerProperties);

    // 이 자동으로 '막는' 기능이 있어 BlockingQueue 의 구현체는 모두 Thread-safe 하다.
    // LinkedBlockingQueue : 선택적으로 Bound가 가능한 Linked list로 구현한 Queue
    // capacity를 초기에 정해주지 않는경우 integer.MAX_VALUE로 자동설정
    // 용량을 초과하지 않는 한에서 node는 동적으로 삽입시마다 생성되며 초과 시 block.
    // Linked queue는 일반적으로 배열 기반 큐 보다 동시성 App에서 높은 throughput을 가짐.
    final BlockingQueue<ConsumerRecord<Integer, String>> records = new LinkedBlockingQueue<>();
    container.setupMessageListener((MessageListener<Integer, String>) record -> {
      System.out.println("record : " + record);
      records.add(record);
    });

    container.setBeanName("templateTests");
    container.start();

    // 컨테이너에 필요한 수의 할당 된 파티션이있을 때까지 기다립니다.
    System.out.println("embeddedKafka.getPartitionsPerTopic() : " + embeddedKafka.getPartitionsPerTopic());
    ContainerTestUtils.waitForAssignment(container, embeddedKafka.getPartitionsPerTopic());



    // 2. 프로듀서에 대한 테스트 속성을 설정합니다.
    Map<String, Object> producerProps = KafkaTestUtils.producerProps(embeddedKafka);
    DefaultKafkaProducerFactory<Integer, String> integerStringDefaultKafkaProducerFactory =
        new DefaultKafkaProducerFactory<>(producerProps);

    KafkaTemplate<Integer, String> template = new KafkaTemplate<>(integerStringDefaultKafkaProducerFactory);
    template.setDefaultTopic(STREAMING_TOPIC1);
    template.sendDefault("foo");

    // 검증
    // AssertJ
    assertThat(records.poll(10, TimeUnit.SECONDS)).has(value("foo"));
    template.sendDefault(0, 2, "bar");
    ConsumerRecord<Integer, String> received = records.poll(10, TimeUnit.SECONDS);

    assertThat(received).has(key(2));
    assertThat(received).has(partition(0));
    assertThat(received).has(value("bar"));

    template.send(STREAMING_TOPIC1, 0, 2, "baz");
    received = records.poll(10, TimeUnit.SECONDS);
    assertThat(received).has(key(2));
    assertThat(received).has(partition(0));
    assertThat(received).has(value("baz"));

    // hamcrest
    /*
    assertThat(records.poll(10, TimeUnit.SECONDS), hasValue("foo"));
    template.sendDefault(0, 2, "bar");
    ConsumerRecord<Integer, String> received = records.poll(10, TimeUnit.SECONDS);
    assertThat(received, hasKey(2));
    assertThat(received, hasPartition(0));
    assertThat(received, hasValue("bar"));
    template.send(STREAMING_TOPIC1, 0, 2, "baz");
    received = records.poll(10, TimeUnit.SECONDS);
    assertThat(received, hasKey(2));
    assertThat(received, hasPartition(0));
    assertThat(received, hasValue("baz"));
    */

  }

}
