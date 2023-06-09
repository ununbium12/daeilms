package com.example.final_201930325.service.impl;

import com.example.final_201930325.dao.OrderDAO;
import com.example.final_201930325.dto.OrderDto;
import com.example.final_201930325.dto.OrderResponseDto;
import com.example.final_201930325.entity.Order;
import com.example.final_201930325.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderDAO orderDAO;

    private String getUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userId = authentication.getName(); // userId가 사용자의 이름으로 저장되어 있는 경우

        return userId;
    }

    @Autowired
    public OrderServiceImpl(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @Override
    public OrderResponseDto getOrder(Long id) {
        Order order = orderDAO.selectOrder(id);

        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setId(order.getId());
        orderResponseDto.setProductId(order.getProductId());
        orderResponseDto.setProductName(order.getProductName());
        orderResponseDto.setUserId(order.getUserId());
        orderResponseDto.setUserName(order.getUserName());
        orderResponseDto.setPrice(order.getPrice());

        return orderResponseDto;
    }

    @Override
    public OrderResponseDto saveOrder(OrderDto orderDto) {
        Order order = new Order();
        String userId = getUserId(); // 로그인된 사용자의 userId를 얻어옴

        order.setProductId(orderDto.getProductId());
        order.setProductName(orderDto.getProductName());
        order.setUserId(userId);
        order.setUserName(orderDto.getUserName());
        order.setPrice(orderDto.getPrice());
        order.setCreatedAt(LocalDateTime.now());
        order.setUpdatedAt(LocalDateTime.now());

        Order saveOrder = orderDAO.insertOrder(order);

        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setId(saveOrder.getId());
        orderResponseDto.setProductId(saveOrder.getProductId());
        orderResponseDto.setProductName(saveOrder.getProductName());
        orderResponseDto.setUserId(saveOrder.getUserId());
        orderResponseDto.setUserName(saveOrder.getUserName());
        orderResponseDto.setPrice(saveOrder.getPrice());

        return orderResponseDto;
    }

    @Override
    public List<OrderResponseDto> getAllOrders() {
        List<Order> orders = orderDAO.selectAllOrders();

        List<OrderResponseDto> orderResponseDtos = new ArrayList<>();
        for(Order order : orders) {
            OrderResponseDto orderResponseDto = new OrderResponseDto();
            orderResponseDto.setId(order.getId());
            orderResponseDto.setProductId(order.getProductId());
            orderResponseDto.setProductName(order.getProductName());
            orderResponseDto.setUserId(order.getUserId());
            orderResponseDto.setUserName(order.getUserName());
            orderResponseDto.setPrice(order.getPrice());
            orderResponseDtos.add(orderResponseDto);
        }

        return orderResponseDtos;
    }

    @Override
    public List<OrderResponseDto> getAllOrdersByUserId(String userId) {
        List<Order> orders = orderDAO.selectAllOrdersByUserId(userId);

        List<OrderResponseDto> orderResponseDtos = new ArrayList<>();
        for(Order order : orders) {
            OrderResponseDto orderResponseDto = new OrderResponseDto();
            orderResponseDto.setId(order.getId());
            orderResponseDto.setProductId(order.getProductId());
            orderResponseDto.setProductName(order.getProductName());
            orderResponseDto.setUserId(order.getUserId());
            orderResponseDto.setUserName(order.getUserName());
            orderResponseDto.setPrice(order.getPrice());
            orderResponseDtos.add(orderResponseDto);
        }

        return orderResponseDtos;
    }

    @Override
    public List<OrderResponseDto> getAllOrdersByProductId(String productId) {
        List<Order> orders = orderDAO.selectAllOrdersByProductId(productId);

        List<OrderResponseDto> orderResponseDtos = new ArrayList<>();
        for(Order order : orders) {
            OrderResponseDto orderResponseDto = new OrderResponseDto();
            orderResponseDto.setId(order.getId());
            orderResponseDto.setProductId(order.getProductId());
            orderResponseDto.setProductName(order.getProductName());
            orderResponseDto.setUserId(order.getUserId());
            orderResponseDto.setUserName(order.getUserName());
            orderResponseDto.setPrice(order.getPrice());
            orderResponseDtos.add(orderResponseDto);
        }

        return orderResponseDtos;
    }
}
