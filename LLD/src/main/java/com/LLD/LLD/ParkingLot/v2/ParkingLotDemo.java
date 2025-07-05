package com.LLD.LLD.ParkingLot.v2;

import com.LLD.LLD.ParkingLot.v2.Enum.VehicleTypeEnum;
import com.LLD.LLD.ParkingLot.v2.Payment.UPIPayment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class ParkingLotDemo {

    public static void main(String[] args) {

        Random random = new Random();

        List<VehicleTypeEnum> indexes = new ArrayList<>();
        indexes.add(VehicleTypeEnum.BIKE);
        indexes.add(VehicleTypeEnum.CAR);
        indexes.add(VehicleTypeEnum.TRUCK);

        List<ParkingFloor> parkingFloors = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            List<ParkingSpot> parkingSpots = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                parkingSpots.add(new ParkingSpot(j, true, indexes.get(random.nextInt(0, 3))));
            }
            parkingFloors.add(new ParkingFloor(i, parkingSpots));
        }

        ParkingLot parkingLot = new ParkingLot(new HashMap<>(), parkingFloors);

        parkingLot.getAvailableParkingSpots();

        List<Integer> result = parkingLot.getRelevantParkingSpot(VehicleTypeEnum.BIKE);

        Integer ticketId = parkingLot.parkVehicle(result.get(0), result.get(1), 5);

        parkingLot.getAvailableParkingSpots();

        parkingLot.unParkVehicle(ticketId, 10, new UPIPayment());
        parkingLot.getAvailableParkingSpots();
    }
}
