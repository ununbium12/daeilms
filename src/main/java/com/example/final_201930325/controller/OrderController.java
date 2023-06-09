package com.example.final_201930325.controller;

import com.example.final_201930325.dto.OrderDto;
import com.example.final_201930325.dto.OrderResponseDto;
import com.example.final_201930325.dto.ProductDto;
import com.example.final_201930325.entity.Product;
import com.example.final_201930325.service.OrderService;
import com.example.final_201930325.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    private final ProductService productService;

    @Autowired
    public OrderController(OrderService orderService, ProductService productService) {
        this.orderService = orderService;
        this.productService = productService;
    }

    @GetMapping("/")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<OrderResponseDto> getOrder(Long id) {
        OrderResponseDto orderResponseDto = orderService.getOrder(id);
        return ResponseEntity.status(HttpStatus.OK).body(orderResponseDto);
    }

    @PostMapping("/order")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<OrderResponseDto> createOrder(@RequestBody OrderDto orderDto) {
        OrderResponseDto orderResponseDto = orderService.saveOrder(orderDto);
        Product product = productService.getProductById(orderDto.getProductId());
        if(product == null || product.getStock() == 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(orderResponseDto);
        }
        if (Long.parseLong(orderDto.getProductId()) == product.getNumber() && product.getStock() > 0) {
            product.setStock(product.getStock() - 1);
            ProductDto productDto = new ProductDto(product.getName(),product.getPrice(),product.getStock());
            productService.saveProduct(productDto);
        }
        return ResponseEntity.status(HttpStatus.OK).body(orderResponseDto);
    }

    @GetMapping("/list")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<OrderResponseDto>> getOrderList() {
        List<OrderResponseDto> orderList = orderService.getAllOrders();
        return ResponseEntity.status(HttpStatus.OK).body(orderList);
    }

    @GetMapping("/listByUserId")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<OrderResponseDto>> getOrderListByUserId(String userId) {
        List<OrderResponseDto> orderList = orderService.getAllOrdersByUserId(userId);
        return ResponseEntity.status(HttpStatus.OK).body(orderList);
    }

    @GetMapping("/listByProductId")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<OrderResponseDto>> getOrderListByProductId(String productId) {
        List<OrderResponseDto> orderList = orderService.getAllOrdersByProductId(productId);
        return ResponseEntity.status(HttpStatus.OK).body(orderList);
    }
}
