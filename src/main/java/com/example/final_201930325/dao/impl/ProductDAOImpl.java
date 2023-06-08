package com.example.final_201930325.dao.impl;

import com.example.final_201930325.dao.ProductDAO;
import com.example.final_201930325.entity.Product;
import com.example.final_201930325.repository.ProductRepository;
import com.example.final_201930325.repository.QProductRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.querydsl.jpa.impl.JPAQueryFactory;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class ProductDAOImpl implements ProductDAO {

    private final ProductRepository productRepository;
    private final JPAQueryFactory jpaQueryFactory;
    private final QProductRespository qProductRespository;

    @Autowired
    public ProductDAOImpl(ProductRepository productRepository, JPAQueryFactory jpaQueryFactory, ) {
        this.productRepository = productRepository;
        this.jpaQueryFactory = jpaQueryFactory;
        this.qProductRespository = qProductRespository;
    }

    @Override
    public List<Product> allProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product insertProduct(Product product) {
        Product saveProduct = productRepository.save(product);
        return saveProduct;
    }

    @Override
    public Product selectProduct(Long number) {
        Product selectProduct = productRepository.getReferenceById(number);
        return selectProduct;
    }


    @Override
    public List<Product> selectProductByName(String name, Sort sort) {
        List<Product> selectProduct = productRepository.findByName(name, sort);
        return selectProduct;
    }

    @Override
    public Long countByPrice(int price) {
        return productRepository.countByPrice(price);
    }

    @Override
    public boolean existsByNumber(Long number) {
        return productRepository.existsByNumber(number);
    }

    @Override
    public Product selectFindByNameAndPrice(String name, int price) {
        return productRepository.findByNameAndPrice(name, price);
    }

    @Override
    public List<Product> listProductByName(String name) {
        return productRepository.findByNameOrderByPriceDesc(name);
    }

    @Override
    public List<Product> listProduct() {
        return productRepository.findAllByOrderByPriceAsc();
    }

    @Override
    public List<Product> listByStock(int stock) {
        return productRepository.listByStock(stock);
    }

    @Override
    public Product updateProductName(Long number, String name) throws Exception {
        Optional<Product> selectedProduct = productRepository.findById(number);

        Product updateProduct;
        if(selectedProduct.isPresent()) {
            Product product = selectedProduct.get();
            product.setName(name);
            product.setUpdatedAt(LocalDateTime.now());

            updateProduct = productRepository.save(product);
        } else throw new Exception();
        return updateProduct;
    }

    @Override
    public void deleteProduct(Long number) throws Exception {
        Optional<Product> selectedProduct = productRepository.findById(number);

        if(selectedProduct.isPresent()) {
            Product product = selectedProduct.get();
            productRepository.delete(product);
        } else throw new Exception();
    }
}
