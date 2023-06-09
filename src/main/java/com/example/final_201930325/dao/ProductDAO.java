package com.example.final_201930325.dao;

import com.example.final_201930325.entity.Product;

import java.util.List;

public interface ProductDAO {

    Product insertProduct(Product product);
    Product selectProduct(Long number);

    Product updateProductName(Long number, String name, int price, int stock) throws Exception;

    void deleteProduct(Long number) throws Exception;

    List<Product> selectAllProducts();
    List<Product> selectAllProductsOrderByPrice();
    List<Product> selectProductsByName(String name);
}
