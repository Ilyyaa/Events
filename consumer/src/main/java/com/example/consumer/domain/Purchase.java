package com.example.consumer.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


@Entity
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;
    private Integer amount;
    private Integer productId;

    public Purchase() {}

    public Purchase(Integer orderId, Integer amount, Integer productId) {
        this.orderId = orderId;
        this.amount = amount;
        this.productId = productId;
    }

    public Integer getEventId() {
        return orderId;
    }

    public Integer getAmount() {
        return amount;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setEventId(Integer orderId) {
        this.orderId = orderId;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}

