package com.LLD.LLD.HotelManagement;

import com.LLD.LLD.BookMyShow.Enum.PaymentTypeEnum;

public class Booking {

    private String bookingId;

    private BookingStatusTypeEnum bookingStatusTypeEnum;

    private int amount;

    private String hotelId;

    private String roomId;

    private String userId;

    private Integer checkinDate;

    private Integer checkOutDate;

    private PaymentTypeEnum paymentTypeEnum;

    public Booking(String bookingId, BookingStatusTypeEnum bookingStatusTypeEnum, int amount, String hotelId,
            String roomId, String userId, Integer checkinDate, Integer checkOutDate, PaymentTypeEnum paymentTypeEnum) {
        this.bookingId = bookingId;
        this.bookingStatusTypeEnum = bookingStatusTypeEnum;
        this.amount = amount;
        this.hotelId = hotelId;
        this.roomId = roomId;
        this.userId = userId;
        this.checkinDate = checkinDate;
        this.checkOutDate = checkOutDate;
        this.paymentTypeEnum = paymentTypeEnum;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public BookingStatusTypeEnum getBookingStatusTypeEnum() {
        return bookingStatusTypeEnum;
    }

    public void setBookingStatusTypeEnum(BookingStatusTypeEnum bookingStatusTypeEnum) {
        this.bookingStatusTypeEnum = bookingStatusTypeEnum;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(Integer checkinDate) {
        this.checkinDate = checkinDate;
    }

    public Integer getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Integer checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public PaymentTypeEnum getPaymentTypeEnum() {
        return paymentTypeEnum;
    }

    public void setPaymentTypeEnum(PaymentTypeEnum paymentTypeEnum) {
        this.paymentTypeEnum = paymentTypeEnum;
    }
}
