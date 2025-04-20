package com.LLD.LLD.Uber;

public class Ride {

    private int rideId;
    private Location startLocation;

    private Location endLocation;
    private int cost;
    private Rider rider;

    private Cab cab;

    private RideStatus rideStatus;

    public Ride(int rideId, Location startLocation, Location endLocation, int cost, Rider rider,RideStatus rideStatus, Cab cab) {
        this.rideId = rideId;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.cost = cost;
        this.rider = rider;
        this.rideStatus = rideStatus;
        this.cab = cab;
    }

    public Cab getCab() {
        return cab;
    }

    public void setCab(Cab cab) {
        this.cab = cab;
    }

    public RideStatus getRideStatus() {
        return rideStatus;
    }

    public void setRideStatus(RideStatus rideStatus) {
        this.rideStatus = rideStatus;
    }

    public int getRideId() {
        return rideId;
    }

    public void setRideId(int rideId) {
        this.rideId = rideId;
    }

    public Location getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(Location startLocation) {
        this.startLocation = startLocation;
    }

    public Location getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(Location endLocation) {
        this.endLocation = endLocation;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Rider getRider() {
        return rider;
    }

    public void setRider(Rider rider) {
        this.rider = rider;
    }


}
