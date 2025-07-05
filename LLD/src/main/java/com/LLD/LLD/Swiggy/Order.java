package com.LLD.LLD.Swiggy;

import com.LLD.LLD.Swiggy.Coupons.Coupon;
import com.LLD.LLD.Swiggy.Enum.OrderStatusEnum;
import com.LLD.LLD.Swiggy.Stratergy.PaymentStratergy;

import java.util.Map;

public class Order {

    private int orderId;

    private OrderStatusEnum orderStatusEnum;

    private int customerId;

    private int deliveryPartnerId;

    private PaymentStratergy paymentStratergy;

    private int restaurantId;

    private Map<String,Integer> itemsAndCount;

    private int cost;

    private Map<Integer, Coupon> coupons;

    public Order(int orderId, OrderStatusEnum orderStatusEnum, int customerId, int deliveryPartnerId, PaymentStratergy paymentStratergy, int restaurantId, Map<String, Integer> itemsAndCount, int cost) {
        this.orderId = orderId;
        this.orderStatusEnum = orderStatusEnum;
        this.customerId = customerId;
        this.deliveryPartnerId = deliveryPartnerId;
        this.paymentStratergy = paymentStratergy;
        this.restaurantId = restaurantId;
        this.itemsAndCount = itemsAndCount;
        this.cost = cost;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public OrderStatusEnum getOrderStatusEnum() {
        return orderStatusEnum;
    }

    public void setOrderStatusEnum(OrderStatusEnum orderStatusEnum) {
        this.orderStatusEnum = orderStatusEnum;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getDeliveryPartnerId() {
        return deliveryPartnerId;
    }

    public void setDeliveryPartnerId(int deliveryPartnerId) {
        this.deliveryPartnerId = deliveryPartnerId;
    }

    public PaymentStratergy getPaymentStratergy() {
        return paymentStratergy;
    }

    public void setPaymentStratergy(PaymentStratergy paymentStratergy) {
        this.paymentStratergy = paymentStratergy;
    }

    public Map<String, Integer> getItemsAndCount() {
        return itemsAndCount;
    }

    public void setItemsAndCount(Map<String, Integer> itemsAndCount) {
        this.itemsAndCount = itemsAndCount;
    }
}
