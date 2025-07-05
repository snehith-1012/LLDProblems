package com.LLD.LLD.BookMyShow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Theatre {

    private String theatreId;

    private String theatreName;

    private String city;

    private Map<String, Show> shows;

    private List<Seat> seats;

    public Theatre(String theatreId, String theatreName, String city, List<Seat> seats) {
        this.theatreId = theatreId;
        this.theatreName = theatreName;
        this.city = city;
        this.seats = seats;
        this.shows = new HashMap<>();
    }

    public String getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(String theatreId) {
        this.theatreId = theatreId;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Map<String, Show> getShows() {
        return shows;
    }

    public void setShows(Map<String, Show> shows) {
        this.shows = shows;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
}
