package com.LLD.LLD.Swiggy;


import com.LLD.LLD.Swiggy.Enum.UserTypeEnum;

import java.util.HashMap;
import java.util.Map;

public abstract class User {

    private int userId;
    private String name;
    private UserTypeEnum userTypeEnum;

    private Map<Integer, Order> orders;

    public User(int userId, String name, UserTypeEnum userTypeEnum) {
        this.userId = userId;
        this.name = name;
        this.userTypeEnum = userTypeEnum;
        this.orders = new HashMap<>();
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserTypeEnum getUserTypeEnum() {
        return userTypeEnum;
    }

    public void setUserTypeEnum(UserTypeEnum userTypeEnum) {
        this.userTypeEnum = userTypeEnum;
    }

    public Map<Integer, Order> getOrders() {
        return orders;
    }

    public void setOrders(Map<Integer, Order> orders) {
        this.orders = orders;
    }
}
