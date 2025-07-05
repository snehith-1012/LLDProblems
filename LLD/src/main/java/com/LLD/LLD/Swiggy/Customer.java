package com.LLD.LLD.Swiggy;


import com.LLD.LLD.Swiggy.Enum.UserTypeEnum;

public class Customer extends User {
    private Cart cart;

    public Customer(int userId, String name) {
        super(userId, name, UserTypeEnum.CUSTOMER);
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
