package com.LLD.LLD.HotelManagement;

import com.LLD.LLD.BookMyShow.Enum.PaymentTypeEnum;
import com.LLD.LLD.HotelManagement.Payment.CashPayment;
import com.LLD.LLD.HotelManagement.Payment.PaymentStratergy;
import com.LLD.LLD.HotelManagement.Payment.UPIPayment;
import com.LLD.LLD.Swiggy.Stratergy.UpiPaymentStratergy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class HotelManagementSystem {

    private Map<String, User> users;

    private Map<String, Hotel> hotels;

    private Map<String, Booking> bookings;

    // hotelId, bookingId
    private Map<String, Map<String, Booking>> hotelBookings = new HashMap<>();

    // userId, bookingId
    private Map<String, Map<String, Booking>> userBookings = new HashMap<>();

    private PaymentStratergy upiPaymentStratergy = new UPIPayment();

    private PaymentStratergy cashPaymentStratergy = new CashPayment();


    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final Random random = new Random();

    public static String generate(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(index));
        }
        return sb.toString();
    }


    public HotelManagementSystem(Map<String, User> users, Map<String, Hotel> hotels, Map<String, Booking> bookings,
                                 Map<String, Map<String, Booking>> hotelBookings,
                                 Map<String, Map<String, Booking>> userBookings) {
        this.users = users;
        this.hotels = hotels;
        this.bookings = bookings;
        this.hotelBookings = hotelBookings;
        this.userBookings = userBookings;
    }

    public Map<String, User> getUsers() {
        return users;
    }

    public void setUsers(Map<String, User> users) {
        this.users = users;
    }

    public Map<String, Hotel> getHotels() {
        return hotels;
    }

    public void setHotels(Map<String, Hotel> hotels) {
        this.hotels = hotels;
    }

    public Map<String, Booking> getBookings() {
        return bookings;
    }

    public void setBookings(Map<String, Booking> bookings) {
        this.bookings = bookings;
    }

    public Map<String, Map<String, Booking>> getHotelBookings() {
        return hotelBookings;
    }

    public void setHotelBookings(Map<String, Map<String, Booking>> hotelBookings) {
        this.hotelBookings = hotelBookings;
    }

    public Map<String, Map<String, Booking>> getUserBookings() {
        return userBookings;
    }

    public void setUserBookings(Map<String, Map<String, Booking>> userBookings) {
        this.userBookings = userBookings;
    }

    public Booking bookRoom(String hotelId, String userId, String roomId, Integer startDate, Integer endDate, PaymentTypeEnum paymentTypeEnum) {
        if (showRoomAvailability(hotelId, roomId, startDate, endDate)) {
            int amount = hotels.get(hotelId).getRooms().get(roomId).getPrice();
            if (amount > users.get(userId).getWalletBalance()) {
                System.out.println("Insufficient wallet balance for booking");
                return null;
            }
            users.get(userId).setWalletBalance(users.get(userId).getWalletBalance() - amount);
            Booking booking = new Booking(generate(7), BookingStatusTypeEnum.BOOKED, amount, hotelId, roomId, userId, startDate, endDate, paymentTypeEnum);
            if (booking.getPaymentTypeEnum() == PaymentTypeEnum.UPI) {
                upiPaymentStratergy.pay(booking.getAmount());
            } else {
                cashPaymentStratergy.pay(booking.getAmount());
            }
            bookings.put(booking.getBookingId(), booking);
            hotelBookings.computeIfAbsent(hotelId, k -> new HashMap<>()).put(booking.getBookingId(), booking);
            userBookings.computeIfAbsent(userId, k -> new HashMap<>()).put(booking.getBookingId(), booking);
            return booking;
        } else {
            System.out.println("room not available for booking");
            return null;
        }
    }

    public void cancelBooking(String bookingId) {
        Booking booking = bookings.get(bookingId);
        hotelBookings.get(booking.getHotelId()).get(bookingId).setBookingStatusTypeEnum(BookingStatusTypeEnum.CANCELLED);
        userBookings.get(booking.getUserId()).get(bookingId).setBookingStatusTypeEnum(BookingStatusTypeEnum.CANCELLED);
        bookings.get(bookingId).setBookingStatusTypeEnum(BookingStatusTypeEnum.CANCELLED);
        if (booking.getPaymentTypeEnum() == PaymentTypeEnum.UPI) {
            upiPaymentStratergy.refund(booking.getAmount());// refund
        } else {
            cashPaymentStratergy.refund(booking.getAmount());
        }
        users.get(booking.getUserId()).setWalletBalance(users.get(booking.getUserId()).getWalletBalance() + booking.getAmount());
    }

    public List<Booking> showBookingsOfUser(String userId) {
        return userBookings.get(userId).values().stream().toList();
    }

    public boolean showRoomAvailability(String hotelId, String roomId, Integer startDate, Integer endDate) {
        if (hotelBookings.containsKey(hotelId)) {
            List<Booking> hotelBookings1 = hotelBookings.get(hotelId).values().stream().toList();
            ;
            for (int i = hotelBookings1.size() - 1; i >= 0; i--) {
                Booking booking = hotelBookings1.get(i);
                if (booking.getRoomId().equals(roomId)) {
                    int bookingStartDate = booking.getCheckinDate();
                    int bookingEndDate = booking.getCheckOutDate();
                    if ((startDate < bookingStartDate && bookingStartDate < endDate && endDate < bookingEndDate) ||
                            (bookingStartDate < startDate && startDate < bookingEndDate && bookingEndDate < endDate) ||
                            (startDate <= bookingStartDate && bookingEndDate <= endDate) ||
                            (bookingStartDate <= startDate && endDate <= bookingEndDate)) {
                        if (booking.getBookingStatusTypeEnum() == BookingStatusTypeEnum.CANCELLED) {
                            return true;
                        }
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
