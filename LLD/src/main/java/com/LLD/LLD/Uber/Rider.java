package com.LLD.LLD.Uber;

import java.util.ArrayList;
import java.util.List;

public class Rider {

    private int userId;

    private String userName;

    private List<Ride> rides;

    public Rider(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;
        this.rides = new ArrayList<>();
    }

    public void addRide(Ride ride){
        this.rides.add(ride);
    }

    public List<Ride> getRides() {
        return rides;
    }

    public void setRides(List<Ride> rides) {
        this.rides = rides;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
