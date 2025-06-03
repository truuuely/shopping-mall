package com.example.shopping.domain.product.dto;

import com.example.shopping.domain.product.domain.Product;
import lombok.Builder;

@Builder
public record ProductRequest(
        String name,
        Integer price,
        Integer amount
) {
    public Product toProduct() {
        return Product.builder()
                .name(name)
                .price(price)
                .amount(amount)
                .build();
    }
}
