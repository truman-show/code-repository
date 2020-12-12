package com.truman.show.config;

import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

/**
 * @KafkaListener Annotation 를 자세히 설명하고 있다.
 * https://docs.spring.io/spring-kafka/reference/html/#kafka-listener-annotation
 */
@EnableKafka  //@KafkaListener 를 사용하려면 필
@Configuration
public class KafkaConsumerConfig {


  @Value("${spring.kafka.bootstrap-servers}")
  private String bootstrapServers;

  // kafkaListenerContainerFactory -> consumerFactory -> consumerConfigs

  // @KafkaListener 주석은 간단한 POJO 리스너를위한 메커니즘을 제공합니다.
  // 이 메커니즘에는 기본 ConcurrentMessageListenerContainer를 구성하는 데 사용되는 리스너 컨테이너 팩토리가 필요합니다.
  // 기본적으로 이름이 kafkaListenerContainerFactory 인 Bean이 필요합니다.
  @Bean
  public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>> kafkaListenerContainerFactory() {
    ConcurrentKafkaListenerContainerFactory<String, String> factory =
        new ConcurrentKafkaListenerContainerFactory<>();
    factory.setConsumerFactory(consumerFactory());
    return factory;
  }

  @Bean
  public Map<String, Object> consumerConfigs() {
    Map<String, Object> props = new HashMap<>();
    props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
        bootstrapServers);
    props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
    props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);

    return props;
  }

  @Bean
  public ConsumerFactory<String, String> consumerFactory() {
    return new DefaultKafkaConsumerFactory<>(consumerConfigs());
  }

}
