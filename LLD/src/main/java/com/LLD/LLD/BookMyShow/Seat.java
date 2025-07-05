package com.LLD.LLD.BookMyShow;

public class Seat {

    private String seatId;

    private Integer price;

    public Seat(String seatId, Integer price) {
        this.seatId = seatId;
        this.price = price;
    }

    public String getSeatId() {
        return seatId;
    }

    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
