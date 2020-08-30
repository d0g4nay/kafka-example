package com.example.kafka.service;

import com.example.kafka.model.User;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaSenderExample {

  private final KafkaTemplate<String, String> kafkaTemplate;
  private final KafkaTemplate<String, User> userKafkaTemplate;

  public KafkaSenderExample(
      KafkaTemplate<String, String> kafkaTemplate, KafkaTemplate<String, User> userKafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
    this.userKafkaTemplate = userKafkaTemplate;
  }

  public void sendMessage(String topicName, String message) {
    kafkaTemplate.send(topicName, message);
  }

  public void sendObjectMessage(String topicName, User user) {
    userKafkaTemplate.send(topicName, user);
  }
}
