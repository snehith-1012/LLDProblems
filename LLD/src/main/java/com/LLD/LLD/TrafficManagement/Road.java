package com.LLD.LLD.TrafficManagement;

import java.util.Queue;

public class Road implements Runnable {

    private int roadId;

    private Signal signal;
    private Queue<Vehicle> vehicles;

    private boolean containsEmergencyVehicle = false;

    private final int vehiclesToBeSent = 4;

    public Road(int roadId, Signal signal, Queue<Vehicle> vehicles) {
        this.roadId = roadId;
        this.signal = signal;
        this.vehicles = vehicles;
    }

    public int getRoadId() {
        return roadId;
    }

    public void setRoadId(int roadId) {
        this.roadId = roadId;
    }

    public Signal getSignal() {
        return signal;
    }

    public void setSignal(Signal signal) {
        this.signal = signal;
    }

    public Queue<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Queue<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public void addVehicle(Vehicle vehicle) {
        this.vehicles.add(vehicle);
    }

    public void removeVehicle() {
        this.vehicles.remove();
    }

    // start popping
    @Override
    public void run() {
        int vehiclesToBePopped = vehiclesToBeSent;

        while (!vehicles.isEmpty()) {
            Vehicle vehicle = vehicles.poll();
            if(vehicle.getVehicleTypeEnum() == VehicleTypeEnum.EMERGENCYVEHICLE && vehiclesToBePopped == 0){
                this.containsEmergencyVehicle = false;
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            if (vehiclesToBePopped <= 0 && this.containsEmergencyVehicle) {

            } else {
                vehiclesToBePopped--;
            }
        }
    }
}
