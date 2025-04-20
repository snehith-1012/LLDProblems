package com.LLD.LLD.zeptoStoreLocater;


import java.util.List;
import java.util.Map;

public class Warehouse {
    private int warehouseId;
    private Location location;
    private Map<Product, Integer> products;

    public Warehouse(Location location, int warehouseId, Map<Product, Integer> products) {
        this.location = location;
        this.warehouseId = warehouseId;
        this.products = products;
    }

    public void addProduct(Product product, int count) {
        this.products.put(product, count);
    }

    public void updateProductCount(Product product, int count) {
        this.products.put(product, this.products.get(product) + count);
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(int warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }
}
