package com.example.producer.controller;

import com.example.dto.PurchaseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class PurchaseController {

    private final KafkaTemplate<String, PurchaseDto> kafkaTemplate;
    private static final String TOPIC = "my-topic";

    @Autowired
    public PurchaseController(KafkaTemplate<String, PurchaseDto> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("")
    public String sendEvent(@RequestBody PurchaseDto purchase) {
        kafkaTemplate.send(TOPIC, purchase);
        return "DTO event sent to Kafka";
    }
}
