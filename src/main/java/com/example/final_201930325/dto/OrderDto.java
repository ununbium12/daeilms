package com.example.final_201930325.dto;

public class OrderDto {

    private String productId;
    private String productName;
    private String userName;
    private int price;

    public OrderDto(String productId, String productName, String userName, int price) {
        this.productId = productId;
        this.productName = productName;
        this.userName = userName;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
