package com.example.shopping.domain.cart.repository;

import com.example.shopping.domain.cart.domain.Cart;
import com.example.shopping.domain.cart.dto.service.CartDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {
    @Query("select c.id as id, p.id as productId, p.name as productName, p.price as productPrice, c.amount as amount from Cart c, Product p where c.productId = p.id and c.userId = :userId")
    List<CartDto> findAllByUserId(@Param("userId") Long userId);

    void deleteAllByUserId(Long userId);
}
