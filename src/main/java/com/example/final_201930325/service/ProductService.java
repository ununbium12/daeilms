package com.example.final_201930325.service;

import com.example.final_201930325.dto.ProductDto;
import com.example.final_201930325.dto.ProductResponseDto;
import com.example.final_201930325.entity.Product;

import java.util.List;

public interface ProductService {

    ProductResponseDto getProduct(Long number);
    ProductResponseDto saveProduct(ProductDto productDto);

    ProductResponseDto changeProductName(Long number, String name, int price, int stock) throws Exception;

    List<ProductResponseDto> getAllProducts();
    List<ProductResponseDto> getAllProductsOrderByPrice();
    List<ProductResponseDto> getProductsByName(String name);

    void deleteProduct(Long number) throws Exception;

    Product getProductById(String productId);
}
