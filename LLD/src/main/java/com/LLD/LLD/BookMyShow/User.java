package com.LLD.LLD.BookMyShow;

import java.util.HashMap;
import java.util.Map;

public class User {
    private String userId;

    private String name;

    private Map<String, Booking> bookings;

    private String email;

    private Integer walletBalance;

    public User(String userId, String name, String email, Integer walletBalance) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.bookings = new HashMap<>();
        this.walletBalance = walletBalance; // Default wallet balance
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

    public Map<String, Booking> getBookings() {
        return bookings;
    }

    public void setBookings(Map<String, Booking> bookings) {
        this.bookings = bookings;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getWalletBalance() {
        return walletBalance;
    }

    public void setWalletBalance(Integer walletBalance) {
        this.walletBalance = walletBalance;
    }
}
