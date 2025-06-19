package com.example.consumer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;


public class OrderDto {

    private Integer orderId;
    private Integer amount;
    private Integer productId;

    public OrderDto() {}

    public OrderDto(Integer orderId, Integer amount, Integer productId) {
        this.orderId = orderId;
        this.amount = amount;
        this.productId = productId;
    }

    @JsonProperty
    public Integer getOrderId() {
        return orderId;
    }

    @JsonProperty
    public Integer getAmount() {
        return amount;
    }

    @JsonProperty
    public Integer getProductId() {
        return productId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}
