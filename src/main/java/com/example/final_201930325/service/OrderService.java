package com.example.final_201930325.service;

import com.example.final_201930325.dto.OrderDto;
import com.example.final_201930325.dto.OrderResponseDto;
import com.example.final_201930325.entity.Order;

import java.util.List;

public interface OrderService {

    OrderResponseDto getOrder(Long id);
    OrderResponseDto saveOrder(OrderDto orderDto);

    List<OrderResponseDto> getAllOrders();
    List<OrderResponseDto> getAllOrdersByUserId(String userId);
    List<OrderResponseDto> getAllOrdersByProductId(String productId);
}
