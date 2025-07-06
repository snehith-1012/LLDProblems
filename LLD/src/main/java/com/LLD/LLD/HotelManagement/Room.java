package com.LLD.LLD.HotelManagement;

import java.util.List;

public class Room {

    private String roomId;

    private List<RoomTypeEnum> roomTypes;

    private int price;


    public Room(String roomId, List<RoomTypeEnum> roomTypes, int price) {
        this.roomId = roomId;
        this.roomTypes = roomTypes;
        this.price = price;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public List<RoomTypeEnum> getRoomTypes() {
        return roomTypes;
    }

    public void setRoomTypes(List<RoomTypeEnum> roomTypes) {
        this.roomTypes = roomTypes;
    }


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
