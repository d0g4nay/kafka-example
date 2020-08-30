package com.example.kafka.service;

import com.example.kafka.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class KafkaListenerExample {

  Logger LOG = LoggerFactory.getLogger(KafkaListenerExample.class);

  @KafkaListener(topics = "reflecetoring-1", groupId = "reflectoring-user")
  void commonListenerForMultipleTopics(
      @Payload String message,
      @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
      @Header(KafkaHeaders.OFFSET) int offset) {
    LOG.info(
        "Received user string event [{}] from partition-{} with offset-{}",
        message,
        partition,
        offset);
  }

  @KafkaListener(
      topics = "reflecetoring-2",
      groupId = "reflectoring-user2",
      containerFactory = "userKafkaListenerContainerFactory")
  void commonListenerForObjectTopics(
      @Payload User user,
      @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
      @Header(KafkaHeaders.OFFSET) int offset) {

    LOG.info("Received user event [{}] from partition-{} with offset-{}", user, partition, offset);
  }
}
