package com.example.final_201930325.repository;

import com.example.final_201930325.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUserId(String userId);

    List<Order> findByProductId(String productId);
}
