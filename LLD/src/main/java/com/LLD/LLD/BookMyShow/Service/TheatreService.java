package com.LLD.LLD.BookMyShow.Service;

import com.LLD.LLD.BookMyShow.Enum.SeatStatus;
import com.LLD.LLD.BookMyShow.Movie;
import com.LLD.LLD.BookMyShow.Seat;
import com.LLD.LLD.BookMyShow.Show;
import com.LLD.LLD.BookMyShow.Theatre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheatreService {

    private Map<String, Map<String, Theatre>> movieVsTheatre;

    private Map<String, Theatre> theatres;

    public TheatreService() {
        this.movieVsTheatre = new HashMap<>();
        this.theatres = new HashMap<>();
    }

    public void addTheatre(Theatre theatre){
        theatres.put(theatre.getTheatreId(), theatre);
    }

    public void removeTheatre(String theatreId){
        theatres.remove(theatreId);
    }

    public Theatre getTheatre(String theatreId){
        return theatres.get(theatreId);
    }

    public void addShow(String theatreId, Show show){
        theatres.get(theatreId).getShows().put(show.getShowId(),show);
        Movie movie = show.getMovie();
        if (!movieVsTheatre.containsKey(movie)) {
            Map<String, Theatre> theatres = new HashMap<>();
            theatres.put(theatreId, theatres.get(theatreId));
            movieVsTheatre.put(movie.getMovieId(), theatres);
        } else {
            Map<String, Theatre> theatres = movieVsTheatre.get(movie.getMovieId());
            theatres.put(theatreId, theatres.get(theatreId));
        }
    }

    public List<Seat> showSeatAvailability(String theatreId, String showId){
        Theatre theatre = theatres.get(theatreId);
        Show show= theatre.getShows().get(showId);
        List<Seat> availableSeats = new ArrayList<>();
        for(Seat seat: theatre.getSeats()){
            if(!show.getSeatStatusFromSeatId().containsKey(seat.getSeatId())){
                availableSeats.add(seat);
            }
        }
        for(Seat seat: availableSeats){
            System.out.print(seat.getSeatId()+" ");
        }
        System.out.println();
        return availableSeats;
    }

    public Map<Theatre, Map<String, Show>> getShowsByMovie(String city, String movieId) {
        Map<Theatre, Map<String, Show>> showsByTheatre = new HashMap<>();
        Map<String, Theatre> theatres = movieVsTheatre.get(movieId);
        for (Theatre theatre : theatres.values()) {
            if (theatre.getCity().equals(city)) {
                for (Show show : theatre.getShows().values()) {
                    if (show.getMovie().getMovieId().equals(movieId)) {
                        if (!showsByTheatre.containsKey(theatre)) {
                            Map<String, Show> showsMap = new HashMap<>();
                            showsByTheatre.put(theatre, showsMap);
                        } else {
                            showsByTheatre.get(theatre).put(show.getShowId(), show);
                        }
                    }
                }
            }
        }
        return showsByTheatre;
    }

    public void updateSeatReservationStatus(String seatId, String showId, String theatreId) {
        Theatre theatre = theatres.get(theatreId);
        Show show = theatre.getShows().get(showId);

        if (show.getSeatStatusFromSeatId().containsKey(seatId)) {
            show.getSeatStatusFromSeatId().remove(seatId);
        } else {
            show.getSeatStatusFromSeatId().put(seatId, SeatStatus.OCCUPIED);
        }
    }

}
