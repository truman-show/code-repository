package com.truman.show.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.config.TopicBuilder;

//@Configuration
public class KafkaTopicConfig {

  //  @Bean
  public NewTopic topic1() {
    return TopicBuilder.name("test").build();
  }

  //  @Bean
  public NewTopic topic2() {
    return TopicBuilder.name("reflectoring-2").build();
  }

}
