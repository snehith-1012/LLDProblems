package com.LLD.LLD.zeptoStoreLocater;

import java.util.List;
import java.util.Map;

public class Cart {

    private Map<Product, Integer> products;

    public Cart(Map<Product, Integer> products) {
        this.products = products;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }
}
