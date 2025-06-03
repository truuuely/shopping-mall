package com.example.shopping.domain.cart.dto.request;

import com.example.shopping.domain.cart.domain.Cart;

public record CartRequest(
        Long productId,
        Long userId,
        Integer amount
) {
    public Cart toCart() {
        return Cart.builder()
                .productId(productId)
                .userId(userId)
                .amount(amount)
                .build();
    }

}
