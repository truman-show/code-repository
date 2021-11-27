package com.truman.show.sevice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaSenderExample {
  private final KafkaTemplate<String, String> kafkaTemplate;
//  private final NewTopic topic1;

  public void sendMessage(String message, String topicName) {
    kafkaTemplate.send(topicName, message);
  }
/*

  public void sendMessageWithCallback(String message) {
    ListenableFuture<SendResult<String, String>> future =
        kafkaTemplate.send(topic1.name(), message);

    future.addCallback(new ListenableFutureCallback<>() {
      @Override
      public void onSuccess(SendResult<String, String> result) {
        log.info("Message [{}] delivered with offset {}",
            message,
            result.getRecordMetadata().offset());
      }

      @Override
      public void onFailure(Throwable ex) {
        log.warn("Unable to deliver message [{}]. {}",
            message,
            ex.getMessage());
      }
    });
  }
*/

}
