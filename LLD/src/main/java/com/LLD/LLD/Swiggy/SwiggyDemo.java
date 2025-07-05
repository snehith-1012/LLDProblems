package com.LLD.LLD.Swiggy;

import com.LLD.LLD.Swiggy.Coupons.Coupon;
import com.LLD.LLD.Swiggy.Coupons.Hdfc5PercentOffCoupon;
import com.LLD.LLD.Swiggy.Enum.UserAvailabilityEnum;
import com.LLD.LLD.Swiggy.Stratergy.HdfcCardPaymentStratergy;
import com.LLD.LLD.Swiggy.dto.FoodItemRequestObj;

import java.util.List;

public class SwiggyDemo {

    public static void main(String[] args) {
        Swiggy swiggy = Swiggy.getInstance();

        FoodItemRequestObj biryani = new FoodItemRequestObj.builder().name("biryani").price(300).count(3).description("hyderabadi biryani").build();
        FoodItemRequestObj cake = new FoodItemRequestObj.builder().name("cake").price(100).count(2).description("pastery").build();
        FoodItemRequestObj curdRice = new FoodItemRequestObj.builder().name("curdRice").price(120).count(2).description("curd rice").build();

        Restaurant imperio = new Restaurant(1);
        Restaurant meghana = new Restaurant(2);
        Restaurant narmada = new Restaurant(3);

        Restaurant bawarchi = new Restaurant(1);
        Restaurant paradise = new Restaurant(2);

        swiggy.addRestaurant("Bangalore", imperio);
        swiggy.addRestaurant("Bangalore", meghana);
        swiggy.addRestaurant("Bangalore", narmada);

        swiggy.addRestaurant("Hyderabad", bawarchi);
        swiggy.addRestaurant("Hyderabad", paradise);

        // imperio
        swiggy.addFoodItem("Bangalore", 1, biryani);
        swiggy.addFoodItem("Bangalore", 1, cake);

        // meghana
        swiggy.addFoodItem("Bangalore", 2, curdRice);
        swiggy.addFoodItem("Bangalore", 2, cake);

        //narmada
        swiggy.addFoodItem("Bangalore", 3, biryani);
        swiggy.addFoodItem("Bangalore", 3, curdRice);

        FoodItemRequestObj apricotDelight = new FoodItemRequestObj.builder().name("apricotDelight").price(150).count(3).description("apricot delight").build();
        FoodItemRequestObj mangoCream = new FoodItemRequestObj.builder().name("mangoCream").price(110).count(2).description("mango cream").build();

        //bawarchi
        swiggy.addFoodItem("Hyderabad", 1, biryani);
        swiggy.addFoodItem("Hyderabad", 1, curdRice);
        swiggy.addFoodItem("Hyderabad", 1, apricotDelight);

        //paradise
        swiggy.addFoodItem("Hyderabad", 2, biryani);
        swiggy.addFoodItem("Hyderabad", 2, cake);
        swiggy.addFoodItem("Hyderabad", 2, mangoCream);


        // get menu
        List<FoodItem> foodItems = swiggy.getMenu("Hyderabad", 2);
        foodItems.forEach(System.out::println);

        // create users

        User snehith = new Customer(101, "snehith");
        User jayanth = new DeliveryPartner(102, "jayanth", UserAvailabilityEnum.AVAILABILE);

        swiggy.createUser("Hyderabad", snehith);
        swiggy.createUser("Hyderabad", jayanth);

        swiggy.addItemToCart("biryani", 2, 101, 2);
        swiggy.addItemToCart("cake", 2, 101, 1);

        swiggy.createOrder("Hyderabad", 2, 101, new HdfcCardPaymentStratergy(), List.of(new Hdfc5PercentOffCoupon(null)));


    }
}
