package com.LLD.LLD.ParkingLot.v2;

import com.LLD.LLD.ParkingLot.v2.Enum.VehicleTypeEnum;

public class ParkingSpot {

    private Integer parkingSpotId;

    private Boolean isAvailable;

    private VehicleTypeEnum parkingSpotType;

    public ParkingSpot(Integer parkingId, Boolean isAvailable, VehicleTypeEnum parkingSpotType) {
        this.parkingSpotId = parkingId;
        this.isAvailable = isAvailable;
        this.parkingSpotType = parkingSpotType;
    }

    public Integer getParkingSpotId() {
        return parkingSpotId;
    }

    public void setParkingSpotId(Integer parkingId) {
        this.parkingSpotId = parkingId;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public VehicleTypeEnum getParkingSpotType() {
        return parkingSpotType;
    }

    public void setParkingSpotType(VehicleTypeEnum parkingSpotType) {
        this.parkingSpotType = parkingSpotType;
    }
}
