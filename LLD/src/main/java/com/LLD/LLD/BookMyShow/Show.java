package com.LLD.LLD.BookMyShow;

import com.LLD.LLD.BookMyShow.Enum.SeatStatus;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Show {

    private String showId;

    private Movie movie;

    private Map<String, SeatStatus> seatStatusFromSeatId;

    public Show(String showId, Movie movie) {
        this.showId = showId;
        this.movie = movie;
        this.seatStatusFromSeatId = new ConcurrentHashMap<>();
    }

    public String getShowId() {
        return showId;
    }

    public void setShowId(String showId) {
        this.showId = showId;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Map<String, SeatStatus> getSeatStatusFromSeatId() {
        return seatStatusFromSeatId;
    }

    public void setSeatStatusFromSeatId(String seatId, SeatStatus seatStatus) {
        this.seatStatusFromSeatId = seatStatusFromSeatId;
    }
}
