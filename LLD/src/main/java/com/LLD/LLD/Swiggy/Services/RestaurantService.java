package com.LLD.LLD.Swiggy.Services;

import com.LLD.LLD.Swiggy.FoodItem;
import com.LLD.LLD.Swiggy.Restaurant;
import com.LLD.LLD.Swiggy.dto.FoodItemRequestObj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RestaurantService {


    private static RestaurantService instance = null;

    public static RestaurantService getInstance() {
        if (instance == null) {
            return instance = new RestaurantService();
        }
        return instance;
    }

    private RestaurantService() {
    }

    public void addFoodItem(Restaurant restaurant, FoodItemRequestObj foodItemRequestObj) {
        FoodItem foodItem = new FoodItem.builder().name(foodItemRequestObj.getName()).count(foodItemRequestObj.getCount()).price(foodItemRequestObj.getPrice()).description(foodItemRequestObj.getDescription())
                .build();
        restaurant.getItems().put(foodItemRequestObj.getName(), foodItem);
    }

    public void deleteFoodItem(Restaurant restaurant, String name){
        restaurant.getItems().remove(name);
    }

    public void updateFoodItem(Restaurant restaurant, FoodItemRequestObj foodItemRequestObj) {
        FoodItem foodItem = new FoodItem.builder().name(foodItemRequestObj.getName()).count(foodItemRequestObj.getCount()).price(foodItemRequestObj.getCount()).description(foodItemRequestObj.getDescription())
                .build();
        restaurant.getItems().put(foodItemRequestObj.getName(), foodItem);
    }

    public FoodItem getFoodItem(Restaurant restaurant, String name){
        return restaurant.getItems().get(name);
    }

    public List<FoodItem> getMenu(Restaurant restaurant){
        return new ArrayList<>(restaurant.getItems().values());
    }


}
