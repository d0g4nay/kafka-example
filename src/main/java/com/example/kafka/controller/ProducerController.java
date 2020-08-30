package com.example.kafka.controller;

import com.example.kafka.model.User;
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

  @PostMapping("string-produce")
  public void produceMessages() {

    int index = 0;
    while (true) {
      String user = RandomStringUtils.randomAlphanumeric(10);
      kafkaSenderExample.sendMessage("reflecetoring-1", user);

      if (++index == 100) {
        return;
      }
    }
  }

  @PostMapping("object-produce")
  public void objectMessage() {
    int index = 0;
    while (true) {
      String userName = RandomStringUtils.randomAlphanumeric(10);

      User user = new User(userName);
      kafkaSenderExample.sendObjectMessage("reflecetoring-2", user);

      if (++index == 100) {
        return;
      }
    }
  }
}
