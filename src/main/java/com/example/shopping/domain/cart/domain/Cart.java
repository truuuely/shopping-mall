package com.example.shopping.domain.cart.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long userId;

    @Column
    private Long productId;

    @Column
    private int amount;

    @Builder
    public Cart(Long userId, Long productId, int amount) {
        this.userId = userId;
        this.productId = productId;
        this.amount = amount;
    }
}
