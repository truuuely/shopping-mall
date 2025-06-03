package com.example.shopping.domain.cart.dto.response;

import com.example.shopping.domain.cart.dto.service.CartDto;
import lombok.Builder;

@Builder
public record CartResponse(
        Long id,
        Long productId,
        String productName,
        Integer productPrice,
        Integer amount
) {
    public static CartResponse from(CartDto dto) {
        return CartResponse.builder()
                .id(dto.id())
                .productId(dto.productId())
                .productName(dto.productName())
                .productPrice(dto.productPrice())
                .amount(dto.amount())
                .build();
    }
}
