package com.LLD.LLD.Uber;

import org.springframework.util.CollectionUtils;

import java.util.*;

public class RideManagementService {

    private static RideManagementService rideManagementService = null;

    private CabManagementService cabManagementService = CabManagementService.getInstance();

    private List<Driver> drivers = new ArrayList<>();

    private List<Rider> Riders = new ArrayList<>();

    private List<Ride> rides = new ArrayList<>();

    private Map<Rider, List<Cab>> nearestCabsToRider = new HashMap<>();

    private RideManagementService() {
        // create driver
        Driver snehith = new Driver(1, "Snehith");
        Driver jayanth = new Driver(2, "Jayanth");
        Driver avinash = new Driver(3, "Avinash");
        Driver charan = new Driver(4, "charan");
        Driver someone = new Driver(5, "someone");

        drivers.add(snehith);
        drivers.add(jayanth);
        drivers.add(avinash);
        drivers.add(charan);

        // create cabs and assign drivers
        cabManagementService.assignCabToDriver(snehith, "AP201527", "BGLR");
        cabManagementService.assignCabToDriver(jayanth, "AP201627", "BGLR");
        cabManagementService.assignCabToDriver(avinash, "AP201727", "HYD");
        cabManagementService.assignCabToDriver(charan, "AP201827", "BGLR");
        cabManagementService.assignCabToDriver(someone, "AP201927", "BGLR");
    }

    public static RideManagementService getInstance() {
        if (rideManagementService == null) {
            rideManagementService = new RideManagementService();
        }
        return rideManagementService;
    }

    public Cab requestCabsForRide(Rider rider, Location riderLocation, int check) {
        List<Cab> nearestCabs = new ArrayList<>();
        if (CollectionUtils.isEmpty(nearestCabsToRider.get(rider))) {
            nearestCabs = cabManagementService.getNearestCabs("BGLR", riderLocation);
        } else {
            nearestCabs = nearestCabsToRider.get(rider);
        }
        for (Cab cab : nearestCabs) {
            System.out.println(cab.getDriver().getUserName() + " is available at" + cab.getLocationDistanceFromCab(riderLocation));
        }
        if (check >= nearestCabs.size()) {
            return null;
        }
        return nearestCabs.get(check).isAvailable() ? nearestCabs.get(check) : null;
    }

    public Ride acceptRide(int rideId, Cab cab, Rider rider, Location riderLocation, Location startLocation, Location endLocation) {
        Ride ride = null;
        if (cab.acceptRide()) {
            nearestCabsToRider.remove(rider);
            ride = new Ride(rideId, startLocation, endLocation, calculateCost(startLocation, endLocation), rider, RideStatus.IN_PROGRESS, cab);
            cab.setAvailable(false);
            rides.add(ride);
            System.out.println(cab.getDriver().getUserName()+" "+ " is on the way");
        }
        return ride;
    }

    public void endRide(Ride ride) {
        ride.setRideStatus(RideStatus.ENDED);
        ride.getCab().setAvailable(true);
        ride.getCab().setCurrentLocation(ride.getEndLocation());
        ride.getRider().addRide(ride);
        ride.getCab().getDriver().addRide(ride);
        rides.remove(ride);
        ride.getCab().setCurrentLocation(ride.getEndLocation());
        System.out.println(cabManagementService.getCabs());
//        cabManagementService.updateCabLocation(ride, ride.getEndLocation());
    }

    public int calculateCost(Location startLocation, Location endLocation) {
        return Math.abs(startLocation.getLongitude() - endLocation.getLongitude()) + Math.abs(startLocation.getLatitude() - endLocation.getLatitude());
    }

}
