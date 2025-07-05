package com.LLD.LLD.ParkingLot.v1.Vehicle;

import java.util.ArrayList;
import java.util.List;

//@Getter
//@Setter
public class Level {

    private final int floor;
    private final List<ParkingSpot> spots;

    public int getFloor() {
        return floor;
    }

    public List<ParkingSpot> getSpots() {
        return spots;
    }

    public Level(int floor, int capacity) {
        this.floor = floor;
        spots = new ArrayList<>();

        int numBikes = capacity / 2;
        int numCars = capacity / 3;

        for (int i = 0; i < numBikes; i++) {
            spots.add(new ParkingSpot(i, VehicleTypeEnum.BIKE));
        }

        for (int i = numBikes; i < numBikes + numCars; i++) {
            spots.add(new ParkingSpot(i, VehicleTypeEnum.CAR));
        }

        for (int i = numBikes + numCars; i < capacity; i++) {
            spots.add(new ParkingSpot(i, VehicleTypeEnum.TRUCK));
        }
    }

    public synchronized boolean parkVehicle(Vehicle vehicle) {
        for (ParkingSpot parkingSpot : spots) {
            if (parkingSpot.isAvailable() && parkingSpot.getVehicleTypeEnum() == vehicle.getVehicleTypeEnum()) {
                parkingSpot.parkVehicle(vehicle);
                return true;
            }
        }
        return false;
    }

    public synchronized boolean unParkVehicle(Vehicle vehicle) {
        for (ParkingSpot parkingSpot : spots) {
            if (!parkingSpot.isAvailable() && parkingSpot.getParkedVehicle().getVehicleNumber().equals(vehicle.getVehicleNumber())) {
                parkingSpot.unParkVehicle();
            }
        }
        return false;
    }

    public void displayAvailability(){
        for(ParkingSpot spot: spots){
            if(!spot.isAvailable()){
                System.out.println(spot.getSpotNumber() + "is occupied by " + spot.getParkedVehicle().getVehicleNumber());
            }
        }
    }
}
