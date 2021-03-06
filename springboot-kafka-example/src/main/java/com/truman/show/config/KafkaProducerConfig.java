package com.truman.show.config;

import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
public class KafkaProducerConfig {

  @Value("${spring.kafka.bootstrap-servers}")
  private String bootstrapServers;

  @Value("#{environment.getActiveProfiles()[0]}")
  private String valueTest;

  @Bean
  public Map<String, Object> producerConfigs() {
    System.out.println("valueTest" + valueTest);
    Map<String, Object> props = new HashMap<>();
    //Kafka가 실행중인 호스트 및 포트입니다.
    props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);

    //키(key)에 사용할 Serializer 클래스입니다.
    props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
        StringSerializer.class);
    // 값(value)에 사용할 Serializer 클래스입니다.
    props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
        StringSerializer.class);
    return props;
  }

  @Bean
  public ProducerFactory<String, String> producerFactory() {
    return new DefaultKafkaProducerFactory<>(producerConfigs());
  }

  @Bean
  public KafkaTemplate<String, String> kafkaTemplate() {
    return new KafkaTemplate<>(producerFactory());
  }


}
