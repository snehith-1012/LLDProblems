package com.LLD.LLD.Swiggy;

import java.util.HashMap;
import java.util.Map;

public class Cart {

    private int restaurantId;

    // name to count map
    private Map<String, Integer> foodItems;

    public Cart(int restaurantId) {
        this.restaurantId = restaurantId;
        this.foodItems = new HashMap<>();
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Map<String, Integer> getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(Map<String, Integer> foodItems) {
        this.foodItems = foodItems;
    }
}
