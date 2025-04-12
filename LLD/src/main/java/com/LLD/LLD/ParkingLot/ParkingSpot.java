package com.LLD.LLD.ParkingLot;

import com.LLD.LLD.ParkingLot.Vehicle.Vehicle;
import com.LLD.LLD.ParkingLot.Vehicle.VehicleTypeEnum;
import lombok.Getter;
import lombok.Setter;

//@Getter
@Setter
public class ParkingSpot {

    private final int spotNumber;
    private final VehicleTypeEnum vehicleTypeEnum;
    private Vehicle parkedVehicle;

    public ParkingSpot(int spotNumber, VehicleTypeEnum vehicleTypeEnum) {
        this.spotNumber = spotNumber;
        this.vehicleTypeEnum = vehicleTypeEnum;
    }

    public boolean isAvailable() {
        return parkedVehicle == null;
    }

    public synchronized boolean parkVehicle(Vehicle vehicle) {
        if (isAvailable() && vehicle.getVehicleTypeEnum() == vehicleTypeEnum) {
            parkedVehicle = vehicle;
            return true;
        }
        return false;
    }

    public synchronized void unParkVehicle() {
        parkedVehicle = null;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public VehicleTypeEnum getVehicleTypeEnum() {
        return vehicleTypeEnum;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }

    public void setParkedVehicle(Vehicle parkedVehicle) {
        this.parkedVehicle = parkedVehicle;
    }

}
