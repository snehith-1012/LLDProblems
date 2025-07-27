package com.LLD.LLD.LibraryManagement;

import java.util.List;
import java.util.Map;
import java.util.Queue;

public class User {

    private String userId;
    private String name;
    private String email;
    private boolean isBookLimitReached;

    private Queue<Notification> notificationQueue;

    private Map<String, Order> orders;

    public User(String userId, String name, String email, Queue<Notification> notificationQueue, Map<String, Order> orders) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.notificationQueue = notificationQueue;
        this.orders = orders;
        isBookLimitReached =false;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Queue<Notification> getNotificationQueue() {
        return notificationQueue;
    }

    public void setNotificationQueue(Queue<Notification> notificationQueue) {
        this.notificationQueue = notificationQueue;
    }

    public void addNotification(Notification notification) {
        this.notificationQueue.add(notification);
    }

    public Map<String, Order> getOrders() {
        return orders;
    }

    public void setOrders(Map<String, Order> orders) {
        this.orders = orders;
    }

    public void addOrder(Order order) {
        this.orders.put(order.getOrderId(), order);
    }

    public boolean isBookLimitReached() {
        return isBookLimitReached;
    }

    public void setBookLimitReached(boolean bookLimitReached) {
        isBookLimitReached = bookLimitReached;
    }
}
