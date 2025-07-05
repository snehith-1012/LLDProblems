package com.LLD.LLD.BookMyShow;

import com.LLD.LLD.BookMyShow.Enum.PaymentTypeEnum;

import java.util.List;

public class Booking {
    private String bookingId;

    private String theaterId;

    private String showId;

    private String city;

    private List<Integer> seats;

    private PaymentTypeEnum paymentTypeEnum;

    private Integer amountPaid;

    private boolean isCancelled;

    public Booking(String bookingId, String theaterId, String showId, String city, List<Integer> seats, PaymentTypeEnum paymentTypeEnum, Integer amountPaid, boolean isCancelled) {
        this.bookingId = bookingId;
        this.theaterId = theaterId;
        this.showId = showId;
        this.city = city;
        this.seats = seats;
        this.paymentTypeEnum = paymentTypeEnum;
        this.amountPaid = amountPaid;
        this.isCancelled = isCancelled;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(String theaterId) {
        this.theaterId = theaterId;
    }

    public String getShowId() {
        return showId;
    }

    public void setShowId(String showId) {
        this.showId = showId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Integer> getSeats() {
        return seats;
    }

    public void setSeats(List<Integer> seats) {
        this.seats = seats;
    }

    public PaymentTypeEnum getPaymentTypeEnum() {
        return paymentTypeEnum;
    }

    public void setPaymentTypeEnum(PaymentTypeEnum paymentTypeEnum) {
        this.paymentTypeEnum = paymentTypeEnum;
    }

    public Integer getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(Integer amountPaid) {
        this.amountPaid = amountPaid;
    }

    public boolean isCancelled() {
        return isCancelled;
    }

    public void setCancelled(boolean cancelled) {
        isCancelled = cancelled;
    }
}
