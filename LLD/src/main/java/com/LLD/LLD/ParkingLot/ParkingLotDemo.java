package com.LLD.LLD.ParkingLot;

import com.LLD.LLD.ParkingLot.Vehicle.Vehicle;
import com.LLD.LLD.ParkingLot.Vehicle.VehicleTypeEnum;

public class ParkingLotDemo {

    public static void main(String args[]){
        ParkingLot parkingLot = ParkingLot.getInstance();
        parkingLot.addLevel(new Level(1,10));
        parkingLot.addLevel(new Level(2,8));

        // display availability
        parkingLot.displayAvailability();

        // park vehicle
        Vehicle car = new Vehicle(VehicleTypeEnum.CAR,"AP234512");
        parkingLot.parkVehicle(car);

        // display availability
        parkingLot.displayAvailability();

        // unpark vehicle
        parkingLot.unParkVehicle(car);

        // display availability
        parkingLot.displayAvailability();

    }
}
