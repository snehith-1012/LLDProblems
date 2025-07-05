package com.LLD.LLD.Swiggy.Services;

import com.LLD.LLD.Swiggy.*;
import com.LLD.LLD.Swiggy.Coupons.*;
import com.LLD.LLD.Swiggy.Enum.OrderStatusEnum;
import com.LLD.LLD.Swiggy.Stratergy.HdfcCardPaymentStratergy;
import com.LLD.LLD.Swiggy.Stratergy.PaymentStratergy;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderService {

    private UserService userService = UserService.getInstance();

    private Map<Integer, Order> orders;

    private static OrderService instance = null;

    public static OrderService getInstance() {
        if (instance == null) {
            return instance = new OrderService();
        }
        return instance;
    }

    private OrderService() {
        this.orders = new HashMap<>();
    }

    public Order createOrder(Restaurant restaurant, int userId, int deliveryPartnerUserId, PaymentStratergy paymentStratergy, List<Coupon> coupons) {
        Customer customer = (Customer) userService.getUserInfo(userId);
        Map<String, Integer> cartItems = customer.getCart().getFoodItems();
        if (cartItems.keySet().stream().anyMatch(itemName -> restaurant.getItems().get(itemName).getCount() < cartItems.get(itemName))) {
            System.out.println("order not created due to unavailable quantity");
            return null;
        } else {
            int amountToBePaid = 0;
            for(String itemName: cartItems.keySet()){
                amountToBePaid += restaurant.getItems().get(itemName).getPrice() * cartItems.get(itemName);
            }
            Coupon coupon = new NoCoupon();
            Coupon rupee50OffOn500Coupon = new Rupee50OffOn500Coupon(coupon);
            if (paymentStratergy instanceof HdfcCardPaymentStratergy) {
                Coupon hdfc5PercentOffCoupon = new Hdfc5PercentOffCoupon(rupee50OffOn500Coupon);
                amountToBePaid = hdfc5PercentOffCoupon.getDiscountedPrice(amountToBePaid);
            } else {
                Coupon rupayCreditCard12PercentOffCoupon = new RupayCreditCard12PercentOffCoupon(rupee50OffOn500Coupon);
                amountToBePaid = rupayCreditCard12PercentOffCoupon.getDiscountedPrice(amountToBePaid);
            }
            paymentStratergy.pay(amountToBePaid);
            Map<String, Integer> cartItemsCopy = Collections.unmodifiableMap(cartItems);
            Order order = new Order(100 + orders.size() + 1, OrderStatusEnum.DELIVERED, userId, deliveryPartnerUserId, paymentStratergy, restaurant.getRestaurantId(), cartItemsCopy, amountToBePaid);
            cartItems.clear();
            customer.getOrders().put(order.getOrderId(), order);
            DeliveryPartner deliveryPartner = (DeliveryPartner) userService.getUserInfo(deliveryPartnerUserId);
            deliveryPartner.getOrders().put(order.getOrderId(), order);
            return order;
        }
    }

    public void cancelOrder(int orderId) {
        Order order = orders.get(orderId);
        Customer customer = (Customer) userService.getUserInfo(order.getCustomerId());
        DeliveryPartner deliveryPartner = (DeliveryPartner) userService.getUserInfo(order.getDeliveryPartnerId());

        customer.getOrders().get(orderId).setOrderStatusEnum(OrderStatusEnum.CANCELLED);
        deliveryPartner.getOrders().get(orderId).setOrderStatusEnum(OrderStatusEnum.CANCELLED);
        //need to refund
        //use stratergy
    }
}
