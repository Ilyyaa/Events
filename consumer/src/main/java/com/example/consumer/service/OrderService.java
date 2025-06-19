package com.example.consumer.service;

import com.example.consumer.domain.Order;
import com.example.consumer.dto.OrderDto;
import com.example.consumer.listener.OrderListener;
import com.example.consumer.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final OrderRepository repository;

    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

    public OrderService(OrderRepository repository){
        this.repository = repository;
    }

    @Transactional
    public void save(OrderDto orderDto){
        Order order = new Order(orderDto.getOrderId(), orderDto.getAmount(), orderDto.getProductId());
        repository.save(order);
        try{
            externalService.call(order);
            logger.info("");
        }
        catch (Exception){

        }
    }
}
