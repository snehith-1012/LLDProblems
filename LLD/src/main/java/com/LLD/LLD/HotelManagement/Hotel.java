package com.LLD.LLD.HotelManagement;

import java.util.Map;

public class Hotel {

    private String hotelId;

    private Map<String, Room> rooms;

    public Hotel(String hotelId, Map<String, Room> rooms) {
        this.hotelId = hotelId;
        this.rooms = rooms;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public Map<String, Room> getRooms() {
        return rooms;
    }

    public void setRooms(Map<String, Room> rooms) {
        this.rooms = rooms;
    }
}
