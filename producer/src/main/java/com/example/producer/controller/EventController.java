package com.example.producer.controller;

import com.example.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/events")
public class EventController {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private static final String TOPIC = "my-topic";

    @Autowired
    public EventController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("")
    public String sendEvent(@RequestBody String eventJson) {
        // Use eventJson as the message value directly
        kafkaTemplate.send(TOPIC, null, eventJson);
        return "JSON event sent to Kafka";
    }
}
