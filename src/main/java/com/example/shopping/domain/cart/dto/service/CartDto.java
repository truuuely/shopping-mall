package com.example.shopping.domain.cart.dto.service;

public record CartDto(
        Long id,
        Long productId,
        String productName,
        Integer productPrice,
        Integer amount
) {
}
