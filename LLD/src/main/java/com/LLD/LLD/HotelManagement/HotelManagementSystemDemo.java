package com.LLD.LLD.HotelManagement;


import com.LLD.LLD.BookMyShow.Enum.PaymentTypeEnum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HotelManagementSystemDemo {

    public static void main(String[] args) {


        Map<String,User> users = new HashMap<>();
        // create users
        User user1 = new User("101","snehith","snehith@gmail.com", 2000, UserTypeEnum.GUEST);
        User user2 = new User("102","avinash","avinash@gmail.com", 2000, UserTypeEnum.GUEST);

        users.put(user1.getUserId(), user1);
        users.put(user2.getUserId(), user2);



        Map<String,Hotel> hotels = new HashMap<>();
        for (int i = 0; i < 2; i++) {
            Room room1 = new Room("201", List.of(RoomTypeEnum.THREE_BEDDED),1800);
            Room room2 = new Room("202", List.of(RoomTypeEnum.TWO_BEDDED),1200);
            Map<String,Room> rooms = new HashMap<>();
            rooms.put(room1.getRoomId(), room1);
            rooms.put(room2.getRoomId(), room2);
            Hotel hotel = new Hotel(Integer.toString(300+i+1), rooms);
            hotels.put(hotel.getHotelId(), hotel);
        }


        HotelManagementSystem hotelManagementSystem = new HotelManagementSystem(users,hotels, new HashMap<>(), new HashMap<>(), new HashMap<>());

        // user1 books room
        Booking booking1 =hotelManagementSystem.bookRoom("301","101","201",12,15, PaymentTypeEnum.UPI);
        // user2 books same room for same dates
        Booking failedBooking1 = hotelManagementSystem.bookRoom("301","102","201",12,15, PaymentTypeEnum.CREDIT_CARD);

        // user 2 books same room for different dates
        Booking booking2 = hotelManagementSystem.bookRoom("301","102","201",16,20,PaymentTypeEnum.UPI);

        hotelManagementSystem.cancelBooking(booking1.getBookingId());

        // user 2 books same room for cancelled dates by user 1
        Booking succededBooking = hotelManagementSystem.bookRoom("301","102","201",12,15, PaymentTypeEnum.CREDIT_CARD);

        // show user Bookings
        List<Booking> user1Bookings = hotelManagementSystem.showBookingsOfUser("101");
        user1Bookings.forEach(System.out::println);

        List<Booking> user2Bookings = hotelManagementSystem.showBookingsOfUser("102");
        user2Bookings.forEach(System.out::println);
    }
}
