package com.example.kafka.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaSenderExample {

  private final KafkaTemplate<String, String> kafkaTemplate;

  public KafkaSenderExample(KafkaTemplate<String, String> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  public void sendMessage(String topicName, String message) {
    kafkaTemplate.send(topicName, message);
  }
}
