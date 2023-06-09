package com.example.final_201930325.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.example.final_201930325.dao.ProductDAO;
import com.example.final_201930325.dto.ProductDto;
import com.example.final_201930325.dto.ProductResponseDto;
import com.example.final_201930325.entity.Product;
import com.example.final_201930325.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductDAO productDAO;

    @Autowired
    public ProductServiceImpl(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public ProductResponseDto getProduct(Long number) {
        Product product = productDAO.selectProduct(number);

        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setName(product.getName());
        productResponseDto.setNumber(product.getNumber());
        productResponseDto.setPrice(product.getPrice());
        productResponseDto.setStock(product.getStock());

        return productResponseDto;
    }

    @Override
    public ProductResponseDto saveProduct(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setStock(productDto.getStock());
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());

        Product saveProduct = productDAO.insertProduct(product);

        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setName(saveProduct.getName());
        productResponseDto.setNumber(saveProduct.getNumber());
        productResponseDto.setPrice(saveProduct.getPrice());
        productResponseDto.setStock(saveProduct.getStock());
        return productResponseDto;
    }

    @Override
    public ProductResponseDto changeProductName(Long number, String name, int price, int stock) throws Exception {
        Product changeProduct = productDAO.updateProductName(number, name, price, stock);

        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setNumber(changeProduct.getNumber());
        productResponseDto.setName(changeProduct.getName());
        productResponseDto.setPrice(changeProduct.getPrice());
        productResponseDto.setStock(changeProduct.getStock());
        return productResponseDto;
    }

    @Override
    public void deleteProduct(Long number) throws Exception {
        productDAO.deleteProduct(number);
    }

    @Override
    public List<ProductResponseDto> getAllProducts() {
        List<Product> products = productDAO.selectAllProducts();

        List<ProductResponseDto> productResponseDtos = new ArrayList<>();
        for (Product product : products) {
            ProductResponseDto productResponseDto = new ProductResponseDto();
            productResponseDto.setName(product.getName());
            productResponseDto.setNumber(product.getNumber());
            productResponseDto.setPrice(product.getPrice());
            productResponseDto.setStock(product.getStock());
            productResponseDtos.add(productResponseDto);
        }

        return productResponseDtos;
    }

    @Override
    public List<ProductResponseDto> getAllProductsOrderByPrice() {
        List<Product> products = productDAO.selectAllProductsOrderByPrice();

        List<ProductResponseDto> productResponseDtos = new ArrayList<>();
        for (Product product : products) {
            ProductResponseDto productResponseDto = new ProductResponseDto();
            productResponseDto.setName(product.getName());
            productResponseDto.setNumber(product.getNumber());
            productResponseDto.setPrice(product.getPrice());
            productResponseDto.setStock(product.getStock());
            productResponseDtos.add(productResponseDto);
        }

        return productResponseDtos;
    }

    @Override
    public List<ProductResponseDto> getProductsByName(String name) {
        List<Product> products = productDAO.selectProductsByName(name);

        List<ProductResponseDto> productResponseDtos = new ArrayList<>();
        for (Product product : products) {
            ProductResponseDto productResponseDto = new ProductResponseDto();
            productResponseDto.setName(product.getName());
            productResponseDto.setNumber(product.getNumber());
            productResponseDto.setPrice(product.getPrice());
            productResponseDto.setStock(product.getStock());
            productResponseDtos.add(productResponseDto);
        }

        return productResponseDtos;
    }
}