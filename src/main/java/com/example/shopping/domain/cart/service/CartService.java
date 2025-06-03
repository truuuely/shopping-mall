package com.example.shopping.domain.cart.service;

import com.example.shopping.domain.cart.domain.Cart;
import com.example.shopping.domain.cart.dto.service.CartDto;
import com.example.shopping.domain.cart.repository.CartRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;

    public Cart save(Cart cart) {
        return cartRepository.save(cart);
    }

    public List<CartDto> findAll(Long userId) {
        return cartRepository.findAllByUserId(userId);
    }

    @Transactional
    public void deleteAll(Long userId) {
        cartRepository.deleteAllByUserId(userId);
    }
}
