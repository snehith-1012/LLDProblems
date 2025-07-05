package com.LLD.LLD.BookMyShow.Service;

import com.LLD.LLD.BookMyShow.Booking;

import java.util.HashMap;
import java.util.Map;

public class BookingService {

    Map<String, Booking> bookingMap = new HashMap<>();

    public BookingService() {
        this.bookingMap = new HashMap<>();
    }

    public Map<String, Booking> getBookingMap() {
        return bookingMap;
    }

    public void setBookingMap(Map<String, Booking> bookingMap) {
        this.bookingMap = bookingMap;
    }

    public void bookTicket(Booking booking) {
        bookingMap.put(booking.getBookingId(), booking);
    }

    public void cancelTicket(String bookingId) {
        bookingMap.remove(bookingId);
    }
}
