package com.example.kafka.service;

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
    LOG.info("Received user [{}] from partition-{} with offset-{}", message, partition, offset);
  }
}
