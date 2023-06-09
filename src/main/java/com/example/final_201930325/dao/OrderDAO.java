package com.example.final_201930325.dao;

import com.example.final_201930325.entity.Order;

import java.util.List;

public interface OrderDAO {

    Order insertOrder(Order order);
    Order selectOrder(Long id);

    List<Order> selectAllOrders();
    List<Order> selectAllOrdersByUserId(String userId);
    List<Order> selectAllOrdersByProductId(String productId);

}
