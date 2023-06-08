package com.example.final_201930325.dao;

import com.example.final_201930325.entity.Product;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface ProductDAO {

    List<Product> allProduct();

    Product insertProduct(Product product);

    Product selectProduct(Long number);

    List<Product> selectProductByName(String name, Sort sort);

    Long countByPrice(int price);

    boolean existsByNumber(Long number);

    Product selectFindByNameAndPrice(String name, int price);

    List<Product> listProductByName(String name);

    List<Product> listProduct();

    List<Product> listByStock(int stock);

    Product updateProductName(Long number, String name) throws Exception;

    void deleteProduct(Long number) throws Exception;
}
