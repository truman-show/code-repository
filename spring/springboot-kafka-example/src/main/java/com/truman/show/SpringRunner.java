package com.truman.show;

import com.truman.show.config.KafkaConsumerConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SpringRunner implements ApplicationRunner {

  private final KafkaConsumerConfig kafkaConsumerConfig;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    kafkaConsumerConfig.consumerFactory().getKeyDeserializer();
    kafkaConsumerConfig.consumerFactory().getValueDeserializer();
    System.out.println("==================");
  }
}
