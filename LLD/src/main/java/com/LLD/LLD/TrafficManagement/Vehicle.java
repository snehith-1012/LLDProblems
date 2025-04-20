package com.LLD.LLD.TrafficManagement;

public class Vehicle {

    private String vehicleName;
    private VehicleTypeEnum vehicleTypeEnum;

    public Vehicle(String vehicleName, VehicleTypeEnum vehicleTypeEnum) {
        this.vehicleName = vehicleName;
        this.vehicleTypeEnum = vehicleTypeEnum;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public VehicleTypeEnum getVehicleTypeEnum() {
        return vehicleTypeEnum;
    }

    public void setVehicleTypeEnum(VehicleTypeEnum vehicleTypeEnum) {
        this.vehicleTypeEnum = vehicleTypeEnum;
    }
}
