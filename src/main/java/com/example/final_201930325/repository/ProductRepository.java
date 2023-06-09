package com.example.final_201930325.repository;

import com.example.final_201930325.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByOrderByPriceDesc();
    List<Product> findByName(String name);

}
