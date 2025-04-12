package com.LLD.LLD.ParkingLot.Vehicle;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
//@Getter
public class Vehicle {

    private VehicleTypeEnum vehicleTypeEnum;

    private String vehicleNumber;

    public Vehicle(VehicleTypeEnum vehicleTypeEnum , String vehicleNumber){
        this.vehicleTypeEnum = vehicleTypeEnum;
        this.vehicleNumber  = vehicleNumber;
    }

    public VehicleTypeEnum getVehicleTypeEnum() {
        return vehicleTypeEnum;
    }

    public void setVehicleTypeEnum(VehicleTypeEnum vehicleTypeEnum) {
        this.vehicleTypeEnum = vehicleTypeEnum;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

}
