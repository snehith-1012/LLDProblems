package com.LLD.LLD.Uber;

import java.util.*;

public class CabManagementService {

    private static CabManagementService cabManagementService = null;

    // get city wise cabs
    private Map<String, List<Cab>> cabs = new HashMap<>();

    private Random random = new Random();

    private CabManagementService() {
        // create driver
    }

    public static CabManagementService getInstance() {
        if (cabManagementService == null) {
            cabManagementService = new CabManagementService();
        }
        return cabManagementService;
    }

    public void assignCabToDriver(Driver driver, String vehicleNumber, String city) {
        Cab cab = new Cab(vehicleNumber, driver, random.nextBoolean(), new Location(random.nextInt(10), random.nextInt(10)), "BGLR");
        if (cabs.containsKey(city)) {
            cabs.get(city).add(cab);
        } else {
            cabs.put(city, new ArrayList<>(List.of(cab)));
        }

    }

    public void updateCabLocation(Ride ride, Location location) {
        ride.getCab().setCurrentLocation(location);
    }

    public List<Cab> getNearestCabs(String city, Location location) {

        List<Cab> cityCabs = cabs.get(city);
        cityCabs.sort(Comparator.comparing(cab -> cab.getLocationDistanceFromCab(location)));
        return cityCabs;
    }

    public Map<String, List<Cab>> getCabs() {
        return cabs;
    }

    public void setCabs(Map<String, List<Cab>> cabs) {
        this.cabs = cabs;
    }
}
