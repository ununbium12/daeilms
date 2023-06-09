package com.example.final_201930325.controller;

import com.example.final_201930325.dto.ChangeProductDto;
import com.example.final_201930325.dto.ProductDto;
import com.example.final_201930325.dto.ProductResponseDto;
import com.example.final_201930325.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public ResponseEntity<ProductResponseDto> getProduct(Long number) {
        ProductResponseDto productResponseDto = productService.getProduct(number);
        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
    }

    @PostMapping()
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<ProductResponseDto> createProduct(@RequestBody ProductDto productDto) {
        ProductResponseDto productResponseDto = productService.saveProduct(productDto);
        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
    }

    @PutMapping()
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<ProductResponseDto> changeProductName(@RequestBody ChangeProductDto changeProductDto) throws Exception{
        ProductResponseDto productResponseDto = productService.changeProductName(changeProductDto.getNumber(), changeProductDto.getName(), changeProductDto.getPrice(), changeProductDto.getStock());
        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
    }

    @DeleteMapping()
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> deleteProduct(Long number) throws Exception{
        productService.deleteProduct(number);
        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");
    }

    @GetMapping("/list")
    public ResponseEntity<List<ProductResponseDto>> getProductList() {
        List<ProductResponseDto> productList = productService.getAllProducts();
        return ResponseEntity.status(HttpStatus.OK).body(productList);
    }

    @GetMapping("/listOrderByPrice")
    public ResponseEntity<List<ProductResponseDto>> getProductListOrderByPrice() {
        List<ProductResponseDto> productList = productService.getAllProductsOrderByPrice();
        return ResponseEntity.status(HttpStatus.OK).body(productList);
    }

    @GetMapping("/byName")
    public ResponseEntity<List<ProductResponseDto>> getProductListByName(@RequestParam String name) {
        List<ProductResponseDto> productList = productService.getProductsByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(productList);
    }
}
