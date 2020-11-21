package com.truman.show.config.producer;

import com.fasterxml.jackson.databind.json.JsonMapper;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

@Configuration
@RequiredArgsConstructor
public class KafkaProducerConfig {

  private final KafkaProperties kafkaProperties;
  private final JsonMapper jsonMapper;

  @Bean
  public ProducerFactory<String, String> producerFactory() {
    Map<String, Object> configProps =
        new HashMap<>(kafkaProperties.buildProducerProperties());

    return new DefaultKafkaProducerFactory<>(
        configProps,
        new StringSerializer(),
        new JsonSerializer<>(jsonMapper)
    );
  }

  @Bean
  public KafkaTemplate<String, String> kafkaTemplate() {
    return new KafkaTemplate<>(producerFactory());
  }
}
