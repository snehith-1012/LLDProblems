package com.LLD.LLD.Uber;

public class RideManagementDemo {

    public static void main(String[] args) {
        RideManagementService rideManagementService = RideManagementService.getInstance();
        Rider trinath = new Rider(1, "trinath");

        // request cabs for ride
        Cab cab = rideManagementService.requestCabsForRide(trinath, new Location(2, 5), 0);

        Ride ride = null;
        if (cab != null) {
            ride = rideManagementService.acceptRide(1, cab, trinath, new Location(2, 5), new Location(2, 5), new Location(4, 5));
        }
        if (ride != null) {
            rideManagementService.endRide(ride);
        }
    }
}
