package com.example.shopping.domain.product.service;

import com.example.shopping.domain.product.domain.Product;
import com.example.shopping.domain.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid product id"));
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }
}
