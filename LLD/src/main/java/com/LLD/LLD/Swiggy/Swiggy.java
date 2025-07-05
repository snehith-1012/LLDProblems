package com.LLD.LLD.Swiggy;

import com.LLD.LLD.Swiggy.Coupons.Coupon;
import com.LLD.LLD.Swiggy.Enum.OrderStatusEnum;
import com.LLD.LLD.Swiggy.Enum.UserAvailabilityEnum;
import com.LLD.LLD.Swiggy.Enum.UserTypeEnum;
import com.LLD.LLD.Swiggy.Services.OrderService;
import com.LLD.LLD.Swiggy.Services.RestaurantService;
import com.LLD.LLD.Swiggy.Services.UserService;
import com.LLD.LLD.Swiggy.Stratergy.PaymentStratergy;
import com.LLD.LLD.Swiggy.dto.FoodItemRequestObj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Swiggy {

    // city to restaurant
    private Map<String, Map<Integer, Restaurant>> cityRestaurants;

    // item name to restaurant
    private Map<String, Map<Integer, Restaurant>> restaurants;

    // city to delivery partner
    private Map<String, Map<Integer, DeliveryPartner>> deliveryPartners;

    private RestaurantService restaurantService = RestaurantService.getInstance();

    private UserService userService = UserService.getInstance();

    private OrderService orderService = OrderService.getInstance();

    private static Swiggy instance;

    public static Swiggy getInstance() {
        if (instance == null) {
            return instance = new Swiggy();
        }
        return instance;
    }

    private Swiggy() {
        this.cityRestaurants = new HashMap<>();
        this.restaurants = new HashMap<>();
        this.deliveryPartners = new HashMap<>();
    }

    // restaurants service
    public void addRestaurant(String city, Restaurant restaurant) {
        if (cityRestaurants.containsKey(city)) {
            cityRestaurants.get(city).put(restaurant.getRestaurantId(), restaurant);
        } else {
            Map<Integer, Restaurant> res = new HashMap<>();
            res.put(restaurant.getRestaurantId(), restaurant);
            cityRestaurants.put(city, res);
        }
        for (String item : restaurant.getItems().keySet()) {
            if (restaurant.getItems().containsKey(item)) {
                Map<Integer, Restaurant> res = new HashMap<>();
                res.put(restaurant.getRestaurantId(), restaurant);
                restaurants.put(item, res);
            } else {
                restaurants.get(item).put(restaurant.getRestaurantId(), restaurant);
            }
        }
    }

    public void addFoodItem(String city, int restaurantId, FoodItemRequestObj foodItemRequestObj) {
        Restaurant restaurant = cityRestaurants.get(city).get(restaurantId);
        if (!restaurants.containsKey(foodItemRequestObj.getName())) {
            Map<Integer, Restaurant> res = new HashMap<Integer, Restaurant>();
            res.put(restaurantId, restaurant);
            restaurants.put(foodItemRequestObj.getName(), res);
        } else {
            restaurants.get(foodItemRequestObj.getName()).put(restaurantId, restaurant);
        }
        restaurantService.addFoodItem(restaurant, foodItemRequestObj);
    }

    public void deleteFoodItem(String city, int restaurantId, String name) {
        Restaurant restaurant = cityRestaurants.get(city).get(restaurantId);
        restaurants.get(name).remove(restaurantId);
        restaurantService.deleteFoodItem(restaurant, name);
    }

    public void updateFoodItem(String city, int restaurantId, FoodItemRequestObj foodItemRequestObj) {
        Restaurant restaurant = cityRestaurants.get(city).get(restaurantId);
        restaurants.get(foodItemRequestObj.getName()).put(restaurantId, restaurant);
        restaurantService.updateFoodItem(restaurant, foodItemRequestObj);
    }

    public FoodItem getFoodItem(String city, int restaurantId, String name) {
        Restaurant restaurant = cityRestaurants.get(city).get(restaurantId);
        return restaurantService.getFoodItem(restaurant, name);
    }

    public List<FoodItem> getMenu(String city, int restaurantId) {
        Restaurant restaurant = cityRestaurants.get(city).get(restaurantId);
        return restaurantService.getMenu(restaurant);
    }


    // user service
    public void createUser(String city, User user) {
        if (user.getUserTypeEnum() == UserTypeEnum.DELIVERY_PARTNER) {
            if (deliveryPartners.containsKey(city)) {
                deliveryPartners.get(city).put(user.getUserId(), (DeliveryPartner) user);
            } else {
                Map<Integer, DeliveryPartner> deliveryGuys = new HashMap<>();
                deliveryGuys.put(user.getUserId(), (DeliveryPartner) user);
                deliveryPartners.put(city, deliveryGuys);
            }
        }
        userService.createUser(user);
    }

    public void deleteUser(int userId) {
        userService.deleteUser(userId);
    }

    public void updateUser(User user) {
        userService.updateUser(user);
    }

    public User getUserInfo(int userId) {
        return userService.getUserInfo(userId);
    }

    public void addItemToCart(String itemName, int restaurantId, int userId, int count) {
        userService.addItemToCart(itemName, restaurantId, userId, count);
    }

    public void updateInCart(String itemName, int userId, int count) {
        userService.updateInCart(itemName, userId, count);
    }

    public List<Order> getUserOrders(int userId) {
        return userService.getUserOrders(userId);
    }

    // order service
    public Order createOrder(String city, int restaurantId, int userId, PaymentStratergy paymentStratergy, List<Coupon> coupons) {
        Restaurant restaurant = cityRestaurants.get(city).get(restaurantId);
        int deliveryPartnerUserId = 0;
        for (Integer guyId : deliveryPartners.get(city).keySet()) {
            if (((DeliveryPartner) userService.getUserInfo(guyId)).getUserAvailabilityEnum() == UserAvailabilityEnum.AVAILABILE) {
                deliveryPartnerUserId = userService.getUserInfo(guyId).getUserId();
                break;
            }
        }
        return orderService.createOrder(restaurant, userId, deliveryPartnerUserId, paymentStratergy, coupons);
    }

    public void cancelOrder(int orderId) {
        orderService.cancelOrder(orderId);
    }

    public Map<String, Map<Integer, Restaurant>> getCityRestaurants() {
        return cityRestaurants;
    }

    public void setCityRestaurants(Map<String, Map<Integer, Restaurant>> cityRestaurants) {
        this.cityRestaurants = cityRestaurants;
    }

    public Map<String, Map<Integer, Restaurant>> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(Map<String, Map<Integer, Restaurant>> restaurants) {
        this.restaurants = restaurants;
    }
}
