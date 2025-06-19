package com.example.consumer.listener;

import com.example.consumer.dto.OrderDto;
import com.example.consumer.repository.OrderRepository;
import com.example.consumer.service.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderListener {

    private final OrderRepository orderRepository;
    private final ObjectMapper objectMapper;
    private final OrderService orderService;

    public OrderListener(OrderRepository orderRepository, ObjectMapper objectMapper, OrderService orderService) {
        this.orderRepository = orderRepository;
        this.objectMapper = objectMapper;
        this.orderService = orderService;
    }

    private static final Logger logger = LoggerFactory.getLogger(OrderListener.class);

    @KafkaListener(topics = "my-topic ", groupId = "my-group", containerFactory = "kafkaListenerContainerFactory")
    public void listen(String eventJson) {
        try {
            OrderDto orderDto = objectMapper.readValue(eventJson, OrderDto.class);
            logger.info("Получено событие из Kafka: eventId={}, amount={}", orderDto.getOrderId(), orderDto.getAmount());
            orderService.save(orderDto);

        } catch (Exception e) {
            logger.error("Failed to deserialize event JSON", e);
        }
    }
}
