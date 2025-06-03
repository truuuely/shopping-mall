package com.example.shopping.domain.product.dto;

import com.example.shopping.domain.product.domain.Product;
import lombok.Builder;

@Builder
public record ProductResponse(
        Long id,
        String name,
        int price,
        int amount
) {
    public static ProductResponse from(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .amount(product.getAmount())
                .build();
    }
}
