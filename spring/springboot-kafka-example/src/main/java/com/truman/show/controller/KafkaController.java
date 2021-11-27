package com.truman.show.controller;

import com.truman.show.sevice.KafkaSenderExample;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class KafkaController {

  private final KafkaSenderExample kafkaSenderExample;

  @GetMapping("/kafka/sender")
  public void kafkaTest(){
    kafkaSenderExample.sendMessage("안녕하세요", "test");
  }

}
