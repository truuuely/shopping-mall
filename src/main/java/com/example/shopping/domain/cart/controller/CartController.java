package com.example.shopping.domain.cart.controller;

import com.example.shopping.domain.cart.dto.request.CartRequest;
import com.example.shopping.domain.cart.dto.response.CartResponse;
import com.example.shopping.domain.cart.service.CartService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {
    private final CartService cartService;

    @PostMapping("/add")
    public ResponseEntity<String> addCart(@Valid @RequestBody CartRequest cartRequest) {
        cartService.save(cartRequest.toCart());
        return ResponseEntity.ok().body("성공");
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<CartResponse>> findAllByUserId(@PathVariable Long userId) {
        List<CartResponse> responses = cartService.findAll(userId).stream().map(CartResponse::from).toList();
        return ResponseEntity.ok(responses);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> clear(@PathVariable Long userId) {
        cartService.deleteAll(userId);
        return ResponseEntity.ok("삭제");
    }
}
