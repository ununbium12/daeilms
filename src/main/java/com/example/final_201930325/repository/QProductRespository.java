package com.example.final_201930325.repository;

import com.example.ch14_1.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface QProductRespository
        extends JpaRepository<Product, Long>, QuerydslPredicateExecutor<Product> {
}
