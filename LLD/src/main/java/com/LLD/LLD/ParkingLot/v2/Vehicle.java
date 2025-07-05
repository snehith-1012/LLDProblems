package com.LLD.LLD.ParkingLot.v2;

import com.LLD.LLD.ParkingLot.v2.Enum.VehicleTypeEnum;

public class Vehicle {

    private Integer vehicleNumber;

    private VehicleTypeEnum vehicleTypeEnum;

    public Vehicle(Integer vehicleNumber, VehicleTypeEnum vehicleTypeEnum) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleTypeEnum = vehicleTypeEnum;
    }

    public Integer getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(Integer vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public VehicleTypeEnum getVehicleTypeEnum() {
        return vehicleTypeEnum;
    }

    public void setVehicleTypeEnum(VehicleTypeEnum vehicleTypeEnum) {
        this.vehicleTypeEnum = vehicleTypeEnum;
    }
}
