package com.LLD.LLD.ParkingLot.v2;

import com.LLD.LLD.ParkingLot.v2.Enum.VehicleTypeEnum;
import com.LLD.LLD.ParkingLot.v2.Payment.PaymentStratergy;

import java.util.*;

public class ParkingLot {

    private Map<Integer, Ticket> ticketMap;

    private List<ParkingFloor> parkingFloors;

    public ParkingLot(Map<Integer, Ticket> ticketMap, List<ParkingFloor> parkingFloors) {
        this.ticketMap = ticketMap;
        this.parkingFloors = parkingFloors;
    }

    public Map<Integer, Ticket> getTicketMap() {
        return ticketMap;
    }

    public void setTicketMap(Map<Integer, Ticket> ticketMap) {
        this.ticketMap = ticketMap;
    }

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public void setParkingFloors(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }

    public Map<Integer, List<Integer>> getAvailableParkingSpots() {
        Map<Integer, List<Integer>> availableSpots = new HashMap<>();
        for (ParkingFloor parkingFloor : this.parkingFloors) {
            System.out.println("Floor ID: " + parkingFloor.getFloorId());
            for (ParkingSpot parkingSpot : parkingFloor.getParkingSpots()) {
                if (parkingSpot.getAvailable()) {
                    System.out.print("Spot ID: " + parkingSpot.getParkingSpotId() + " ");
                    availableSpots.computeIfAbsent(parkingFloor.getFloorId(), k -> new ArrayList<>());
                    availableSpots.get(parkingFloor.getFloorId()).add(parkingSpot.getParkingSpotId());
                }
            }
            System.out.println();
        }
        return availableSpots;
    }

    public List<Integer> getRelevantParkingSpot(VehicleTypeEnum vehicleTypeEnum) {
        for (ParkingFloor parkingFloor : this.parkingFloors) {
            for (ParkingSpot parkingSpot : parkingFloor.getParkingSpots()) {
                if (parkingSpot.getParkingSpotType() == vehicleTypeEnum) {
                    return Arrays.asList(parkingFloor.getFloorId(), parkingSpot.getParkingSpotId());
                }
            }
        }
        return null;
    }

    public Integer parkVehicle(Integer floorId, Integer spotId, Integer entryTime) {
        this.parkingFloors.get(floorId).getParkingSpots().get(spotId).setAvailable(false);
        Ticket ticket = new Ticket(new Random().nextInt(), floorId, spotId, entryTime, null);
        ticketMap.put(ticket.getTicketId(), ticket);
        return ticket.getTicketId();
    }

    public void unParkVehicle(Integer ticketId, Integer exitTime, PaymentStratergy paymentStratergy) {
        Ticket ticket = ticketMap.get(ticketId);
        if (ticket != null) {
            ParkingFloor parkingFloor = this.parkingFloors.get(ticket.getFloorId());
            ParkingSpot parkingSpot = parkingFloor.getParkingSpots().get(ticket.getSlotId());
            parkingSpot.setAvailable(true);
            ticket.setExitTime(exitTime);
            Integer entryTime = ticket.getEntryTime();
            paymentStratergy.pay(exitTime - entryTime * 2);
            ticketMap.remove(ticketId);
        }
    }
}
