package com.LLD.LLD.Swiggy.Services;

import com.LLD.LLD.Swiggy.Cart;
import com.LLD.LLD.Swiggy.Customer;
import com.LLD.LLD.Swiggy.Enum.UserTypeEnum;
import com.LLD.LLD.Swiggy.Order;
import com.LLD.LLD.Swiggy.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {


    private static UserService instance = null;

    public static UserService getInstance() {
        if (instance == null) {
            return instance = new UserService();
        }
        return instance;
    }

    private Map<Integer, User> users;

    private UserService() {
        this.users = new HashMap<>();
    }

    // user profile crud
    public void createUser(User user) {
        users.put(user.getUserId(), user);
    }

    public void deleteUser(int userId) {
        users.remove(userId);
    }

    public void updateUser(User user) {
        users.put(user.getUserId(), user);
    }

    public User getUserInfo(int userId) {
        return this.users.get(userId);
    }

    // user cart crud
    public void addItemToCart(String itemName, int restaurantId, int userId, int count) {
        User user = users.get(userId);
        if (user.getUserTypeEnum() == UserTypeEnum.CUSTOMER) {
            Cart userCart = ((Customer) user).getCart();
            if (userCart == null) {
                Map<String, Integer> foodItems = new HashMap<>();
                foodItems.put(itemName, count);
                userCart = new Cart(restaurantId);
                userCart.setFoodItems(foodItems);
                ((Customer)user).setCart(userCart);
            } else {
                int currentRestaurantLinkedToCartId = ((Customer) user).getCart().getRestaurantId();
                if (currentRestaurantLinkedToCartId == 0 || currentRestaurantLinkedToCartId == restaurantId) {
                    if (!userCart.getFoodItems().containsKey(itemName)) {
                        userCart.getFoodItems().put(itemName, count);
                    } else {
                        userCart.getFoodItems().put(itemName, count);
                    }
                } else {
                    userCart.getFoodItems().put(itemName, count);
                    userCart.setRestaurantId(restaurantId);
                }
            }
        }
    }

    public void updateInCart(String itemName, int userId, int count) {
        User user = users.get(userId);
        if (user.getUserTypeEnum() == UserTypeEnum.CUSTOMER) {
            int currentRestaurantLinkedToCartId = ((Customer) user).getCart().getRestaurantId();
            Cart userCart = ((Customer) user).getCart();
            if (count == 0) {
                userCart.getFoodItems().remove(itemName);
                if (userCart.getFoodItems().size() == 0) {
                    userCart.setRestaurantId(0);
                }
            } else {
                userCart.getFoodItems().put(itemName, count);
            }
        }
    }

    // get user orders
    public List<Order> getUserOrders(int userId) {
        Map<Integer, Order> orders = users.get(userId).getOrders();
        return orders.keySet().stream().map(key -> orders.get(key)).toList();
    }

}
