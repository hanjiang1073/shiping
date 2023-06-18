package com.ceam.user.consumer;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class UserConsumer {

    private static final String TOPIC = "user-topic";

    @KafkaListener(topics = TOPIC, groupId = "user-group")
    public void consumeMessage(String message) {
        // 处理接收到的消息逻辑
        System.out.println("Received message: " + message);
    }
}

