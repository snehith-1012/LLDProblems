package com.LLD.LLD.Swiggy;

import java.util.HashMap;
import java.util.Map;

public class Restaurant {

    private int restaurantId;
    private Map<String, FoodItem> items;

    public Restaurant(int restaurantId) {
        this.restaurantId = restaurantId;
        this.items = new HashMap<>();
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Map<String, FoodItem> getItems() {
        return items;
    }

    public void setItems(Map<String, FoodItem> items) {
        this.items = items;
    }
}
