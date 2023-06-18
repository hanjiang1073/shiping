package com.ceam.ship.consumer;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ShipConsumer {

    private static final String TOPIC = "ship-topic";

    @KafkaListener(topics = TOPIC, groupId = "ship-group")
    public void consumeMessage(String message) {
        // 处理接收到的消息逻辑
        System.out.println("Received message: " + message);
    }
}

