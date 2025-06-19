package com.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;


public class PurchaseDto {

    private Integer amount;
    private Integer productId;

    public PurchaseDto() {}

    public PurchaseDto(Integer orderId, Integer amount, Integer productId) {
        this.amount = amount;
        this.productId = productId;
    }

    @JsonProperty
    public Integer getAmount() {
        return amount;
    }

    @JsonProperty
    public Integer getProductId() {
        return productId;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}
