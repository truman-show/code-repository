package com.truman.show;

import java.util.Iterator;
import org.junit.jupiter.api.Test;
import org.springframework.kafka.test.EmbeddedKafkaBroker;
import org.springframework.kafka.test.context.EmbeddedKafka;

@EmbeddedKafka(
    partitions = 1,
    topics = {
        KafkaStreamsTests.STREAMING_TOPIC1,
        KafkaStreamsTests.STREAMING_TOPIC2
    },
    bootstrapServersProperty = "spring.kafka.bootstrap-servers"
)
public class EmbeddedKafkaConditionTests {

  public static final String STREAMING_TOPIC1 = "com.truman.one";
  public static final String STREAMING_TOPIC2 = "com.truman.two";

  @Test
  public void test(EmbeddedKafkaBroker embeddedKafka) {
    String brokersAsString = embeddedKafka.getBrokersAsString();
    System.out.println(brokersAsString);
    System.out.println(embeddedKafka.getKafkaServers());
    Iterator<String> topics = embeddedKafka.getTopics().iterator();
    while (topics.hasNext()) {
      System.out.println(topics.next());
    }
  }

  // 임베디드 브로커를 이제 띄울수있으니까 프로듀서랑 컨슈머를 구현해서 테스트를 해볼까?

}
