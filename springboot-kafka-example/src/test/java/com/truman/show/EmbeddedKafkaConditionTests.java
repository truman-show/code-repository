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
    }
)
public class EmbeddedKafkaConditionTests {

  public static final String STREAMING_TOPIC1 = "com.truman.one";
  public static final String STREAMING_TOPIC2 = "com.truman.two";

  @Test
  public void test(EmbeddedKafkaBroker embeddedKafka) {
    String brokersAsString = embeddedKafka.getBrokersAsString();
    System.out.println(brokersAsString);
    Iterator<String> topics = embeddedKafka.getTopics().iterator();
    while (topics.hasNext()) {
      System.out.println(topics.next());
    }
  }

}
