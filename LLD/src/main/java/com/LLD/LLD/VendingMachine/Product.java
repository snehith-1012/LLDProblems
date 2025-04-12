package com.LLD.LLD.VendingMachine;

public class Product {

    private String productName;
    private ProductTypeEnum productTypeEnum;

    private int price;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public ProductTypeEnum getProductTypeEnum() {
        return productTypeEnum;
    }

    public void setProductTypeEnum(ProductTypeEnum productTypeEnum) {
        this.productTypeEnum = productTypeEnum;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Product(String productName, ProductTypeEnum productTypeEnum, int price) {
        this.productName = productName;
        this.productTypeEnum = productTypeEnum;
        this.price = price;
    }
}
