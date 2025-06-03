package com.example.shopping.domain.product.controller;

import com.example.shopping.domain.product.domain.Product;
import com.example.shopping.domain.product.dto.ProductRequest;
import com.example.shopping.domain.product.dto.ProductResponse;
import com.example.shopping.domain.product.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductResponse>> findAllProducts() {
        List<Product> products = productService.findAll();
        List<ProductResponse> responses = products.stream().map(ProductResponse::from).toList();
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> findProductById(@PathVariable Long id) {
        // 특정 상품 조회
        return ResponseEntity.ok().body(ProductResponse.from(productService.findById(id)));
    }

    @PostMapping
    public ResponseEntity<ProductResponse> saveProduct(@Valid @RequestBody ProductRequest request) {
        Product product = productService.save(request.toProduct());
        return ResponseEntity.ok(ProductResponse.from(product));
    }
}
