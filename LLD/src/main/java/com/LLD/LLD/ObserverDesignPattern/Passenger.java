package com.LLD.LLD.ObserverDesignPattern;

public class Passenger implements Observer {
    @Override
    public int updateLocation(int location) {
        System.out.println("cab is at location" + location);
        return location;
    }
}
