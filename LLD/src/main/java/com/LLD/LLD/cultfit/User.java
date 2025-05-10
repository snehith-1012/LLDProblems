package com.LLD.LLD.cultfit;

import com.LLD.LLD.cultfit.enums.UserTypeEnum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {

    private String userId;

    private UserTypeEnum userTypeEnum;

    private String mobileNumber;

    private Map<String, Booking> bookings;

    public User(String userId, UserTypeEnum userTypeEnum, String mobileNumber) {
        this.userId = userId;
        this.userTypeEnum = userTypeEnum;
        this.mobileNumber = mobileNumber;
        this.bookings = new HashMap<>();
    }

    public void notifySlotBooking(Slot slot) {
        //notify logic
        System.out.println("slot booked at " + slot.getStartTime());
    }

    public void notifySlotCancellation(Slot slot) {
        System.out.println("your slot at time" + slot.getStartTime() + "is cancelled");
    }

    public void addBooking(Booking booking) {
        this.bookings.put(booking.getId() + "", booking);
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public UserTypeEnum getUserTypeEnum() {
        return userTypeEnum;
    }

    public void setUserTypeEnum(UserTypeEnum userTypeEnum) {
        this.userTypeEnum = userTypeEnum;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Map<String, Booking> getBookings() {
        return bookings;
    }

    public void setBookings(Map<String, Booking> bookings) {
        this.bookings = bookings;
    }
}
