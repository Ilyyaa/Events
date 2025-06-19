package com.example.consumer.listener;

import com.example.dto.PurchaseDto;
import com.example.consumer.repository.PurchaseRepository;
import com.example.consumer.service.PurchaseService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PurchaseListener {

    private final PurchaseRepository purchaseRepository;
    private final ObjectMapper objectMapper;
    private final PurchaseService purchaseService;

    public PurchaseListener(PurchaseRepository purchaseRepository, ObjectMapper objectMapper, PurchaseService purchaseService) {
        this.purchaseRepository = purchaseRepository;
        this.objectMapper = objectMapper;
        this.purchaseService = purchaseService;
    }

    private static final Logger logger = LoggerFactory.getLogger(PurchaseListener.class);

    @KafkaListener(topics = "my-topic", groupId = "my-group", containerFactory = "kafkaListenerContainerFactory")
    public void listen(PurchaseDto purchaseDto) {
        try {
            //PurchaseDto purchaseDto = objectMapper.readValue(eventJson, PurchaseDto.class);
            logger.info("Получено событие из Kafka: productId={}, amount={}", purchaseDto.getProductId(), purchaseDto.getAmount());
            purchaseService.save(new PurchaseDto(null,purchaseDto.getAmount(),purchaseDto.getProductId()));

        } catch (Exception e) {
            logger.error("Failed to deserialize event JSON", e);
        }
    }
}
