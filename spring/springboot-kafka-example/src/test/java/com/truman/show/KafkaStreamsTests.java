package com.truman.show;

import static org.assertj.core.api.Assertions.assertThat;

import org.apache.kafka.streams.StreamsConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.test.EmbeddedKafkaBroker;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.kafka.test.utils.KafkaTestUtils;
import org.springframework.test.annotation.DirtiesContext;

@DirtiesContext
@EmbeddedKafka(
    partitions = 1,
    topics = {
        KafkaStreamsTests.STREAMING_TOPIC1,
        KafkaStreamsTests.STREAMING_TOPIC2
    })
public class KafkaStreamsTests {

  public static final String STREAMING_TOPIC1 = "com.truman.one";
  public static final String STREAMING_TOPIC2 = "com.truman.two";

  @Autowired
  private EmbeddedKafkaBroker embeddedKafka;

  @Test
  public void someTest() {
    /*
    Map<String, Object> consumerProps = KafkaTestUtils.consumerProps("testGroup", "true", this.embeddedKafka);
    consumerProps.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
    ConsumerFactory<Integer, String> cf = new DefaultKafkaConsumerFactory<>(consumerProps);
    Consumer<Integer, String> consumer = cf.createConsumer();
    this.embeddedKafka.consumeFromAnEmbeddedTopic(consumer, KafkaStreamsTests.STREAMING_TOPIC2);
    ConsumerRecords<Integer, String> replies = KafkaTestUtils.getRecords(consumer);
    assertThat(replies.count()).isGreaterThanOrEqualTo(1);
    */
    System.out.println(embeddedKafka.getBrokersAsString());
  }
/*

  @Configuration
  @EnableKafkaStreams
  public static class KafkaStreamsConfiguration {

    @Value("${" + EmbeddedKafkaBroker.SPRING_EMBEDDED_KAFKA_BROKERS + "}")
    private String brokerAddresses;

    @Bean(name = KafkaStreamsDefaultConfiguration.DEFAULT_STREAMS_CONFIG_BEAN_NAME)
    public KafkaStreamsConfiguration kStreamsConfigs() {
      Map<String, Object> props = new HashMap<>();
      props.put(StreamsConfig.APPLICATION_ID_CONFIG, "testStreams");
      props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, this.brokerAddresses);
      return new KafkaStreamsConfiguration(props);
    }

  }
*/

}
