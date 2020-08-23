package com.example.kafka.controller;

import com.example.kafka.service.KafkaSenderExample;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

  private final KafkaSenderExample kafkaSenderExample;

  public ProducerController(KafkaSenderExample kafkaSenderExample) {
    this.kafkaSenderExample = kafkaSenderExample;
  }

  @PostMapping("produce")
  public void produceMessages() {

    int index = 0;
    while (true) {
      String user = RandomStringUtils.randomAlphanumeric(10);
      kafkaSenderExample.sendMessage("reflectoring-1", user);

      if (++index == 100) {
        return;
      }
    }
  }
}
