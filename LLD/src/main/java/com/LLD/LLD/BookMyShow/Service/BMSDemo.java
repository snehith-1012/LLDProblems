package com.LLD.LLD.BookMyShow.Service;


import com.LLD.LLD.BookMyShow.*;
import com.LLD.LLD.BookMyShow.Enum.PaymentTypeEnum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BMSDemo {

    public static void main(String[] args) {
        TheatreService theatreService = new TheatreService();
        MovieService movieService = new MovieService();
        UserService userService = new UserService();
        BookingService bookingService = new BookingService();
        PaymentService paymentService = new PaymentService();

        User user1 = new User("101","snehith","snehith@gmail.com",300);
        userService.addUser(user1);

        Movie movie1 = new Movie("201","Avengers","Action", new HashMap<>());
        movieService.addMovie(movie1);

        List<Seat> seats = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            seats.add(new Seat(String.valueOf(i), 100));
        }
        Theatre theatre1 = new Theatre("301","PVR","Hyderabad", seats);
        theatreService.addTheatre(theatre1);

        Show show1 = new Show("401",movie1);
        theatreService.addShow(theatre1.getTheatreId(), show1);

        // display available seats
        theatreService.showSeatAvailability(theatre1.getTheatreId(), show1.getShowId());

        // book a ticket

        List<Integer> userSelectedSeats = new ArrayList<>();
        userSelectedSeats.add(1);
        userSelectedSeats.add(2);
        Booking booking1 = new Booking("501", theatre1.getTheatreId(), show1.getShowId(), "Hyderabad", userSelectedSeats, PaymentTypeEnum.UPI, 200, false);
        bookingService.bookTicket(booking1);
        theatreService.updateSeatReservationStatus("1", "401", "301");
        theatreService.updateSeatReservationStatus("2", "401", "301");
        userService.getUser("101").getBookings().put("501", booking1);
        paymentService.pay(PaymentTypeEnum.UPI, 200);

        // display available seats
        theatreService.showSeatAvailability(theatre1.getTheatreId(), show1.getShowId());

        // cancel a ticket
        bookingService.cancelTicket("501");
        theatreService.updateSeatReservationStatus("1","401","301");
        theatreService.updateSeatReservationStatus("2", "401", "301");
        userService.getUser("101").getBookings().get("501").setCancelled(true);

        // display available seats
        theatreService.showSeatAvailability(theatre1.getTheatreId(), show1.getShowId());

    }


}
