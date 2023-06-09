package com.example.final_201930325.dao.impl;

import com.example.final_201930325.dao.OrderDAO;
import com.example.final_201930325.entity.Board;
import com.example.final_201930325.entity.Order;
import com.example.final_201930325.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderDAOImpl implements OrderDAO {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderDAOImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order insertOrder(Order order) {
        Order saveOrder = orderRepository.save(order);
        return saveOrder;
    }

    @Override
    public Order selectOrder(Long id) {
        Order selectOrder = orderRepository.getReferenceById(id);
        return selectOrder;
    }

    @Override
    public List<Order> selectAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> selectAllOrdersByUserId(String userId) {
        return orderRepository.findByUserId(userId);
    }

    @Override
    public List<Order> selectAllOrdersByProductId(String productId) {
        return orderRepository.findByProductId(productId);
    }
}
