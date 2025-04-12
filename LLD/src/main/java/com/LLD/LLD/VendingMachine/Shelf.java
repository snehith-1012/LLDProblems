package com.LLD.LLD.VendingMachine;

public class Shelf {

    private int shelfId;

    private int quantity;

    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getShelfId() {
        return shelfId;
    }

    public void setShelfId(int shelfId) {
        this.shelfId = shelfId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Shelf(int shelfId, int quantity, Product product) {
        this.shelfId = shelfId;
        this.quantity = quantity;
        this.product = product;
    }

    public void updateQuantity(int quantity){
        this.quantity += quantity;
    }
}
