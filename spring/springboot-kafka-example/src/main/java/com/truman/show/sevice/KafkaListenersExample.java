package com.truman.show.sevice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaListenersExample {

  @KafkaListener(topics = "test", groupId = "myGroup")
  void listener(String data) {
    System.out.println("+=============");
    log.info(data);
    System.out.println("+=============");
  }
//
//  @KafkaListener(
//      topics = "reflectoring-1, reflectoring-2")
//  void commonListenerForMultipleTopics(String message) {
//    log.info("MultipleTopicListener - {}", message);
//  }

}
