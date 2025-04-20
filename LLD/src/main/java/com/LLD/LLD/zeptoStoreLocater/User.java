package com.LLD.LLD.zeptoStoreLocater;

public class User {

    private int userId;

    private Cart cart;

    private Location location;

    public User(int userId, Cart cart, Location location) {
        this.userId = userId;
        this.cart = cart;
        this.location = location;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
