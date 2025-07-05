package com.LLD.LLD.Uber;

import lombok.Builder;

import java.util.Random;

//@Builder
public class Cab {

    private String vehicleNumber;

    private Driver driver;

    private boolean isAvailable;

    private Location currentLocation;

    private String city;

    private Random random = new Random();

    public Cab(String vehicleNumber, Driver driver, boolean isAvailable, Location currentLocation, String city) {
        this.vehicleNumber = vehicleNumber;
        this.driver = driver;
        this.isAvailable = isAvailable;
        this.currentLocation = currentLocation;
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public boolean acceptRide(){
        return random.nextBoolean();
    }

    public int getLocationDistanceFromCab(Location location) {
        return Math.abs(this.currentLocation.getLongitude() - location.getLongitude()) + Math.abs(this.currentLocation.getLatitude() - location.getLatitude());
    }

}
