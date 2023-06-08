package com.example.final_201930325.service;

import com.example.final_201930325.dto.ProductDto;
import com.example.final_201930325.dto.ProductResponseDto;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface ProductService {

    ProductResponseDto getProduct(Long number);
    ProductResponseDto saveProduct(ProductDto productDto);

    List<ProductResponseDto> getProductByName(String name, Sort sort);

    Long countByPrice(int price);

    boolean existsByNumber(Long number);

    ProductResponseDto getProductByNameAndPrice(String name, int price);

    List<ProductResponseDto> listProductByName(String name);

    List<ProductResponseDto> listProduct();

    List<ProductResponseDto> listByStock(int stock);

    ProductResponseDto changeProductName(Long number, String name) throws Exception;

    void deleteProduct(Long number) throws Exception;
}
