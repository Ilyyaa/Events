package com.example.consumer.service;

import com.example.consumer.domain.Purchase;
import com.example.consumer.externalService.ExternalService;
import com.example.dto.PurchaseDto;
import com.example.consumer.repository.PurchaseRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PurchaseService {
    private final PurchaseRepository repository;
    private final ExternalService externalService;

    private static final Logger logger = LoggerFactory.getLogger(PurchaseService.class);

    public PurchaseService(PurchaseRepository repository, ExternalService externalService){
        this.repository = repository;
        this.externalService = externalService;
    }

    @Transactional
    public void save(PurchaseDto purchaseDto){
        Purchase purchase = new Purchase(null, purchaseDto.getAmount(), purchaseDto.getProductId());
        repository.save(purchase);
        try{
            externalService.call(purchase);
            logger.info("");
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
