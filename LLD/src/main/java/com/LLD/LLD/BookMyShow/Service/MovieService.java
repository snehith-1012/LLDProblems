package com.LLD.LLD.BookMyShow.Service;

import com.LLD.LLD.BookMyShow.Movie;

import java.util.HashMap;
import java.util.Map;

public class MovieService {

    private Map<String, Movie> movies;

    public MovieService() {
        this.movies = new HashMap<>();
    }

    public void addMovie(Movie movie) {
        movies.put(movie.getMovieId(), movie);
    }

    public void removeMovie(String movieId) {
        movies.remove(movieId);
    }

    public Movie getMovie(String movieId) {
        return movies.get(movieId);
    }

    public void rateMovie(Movie movie) {
        Movie movieToBeUpdated = movies.get(movie.getMovieId());
        movieToBeUpdated.setRating((movieToBeUpdated.getRating() * movieToBeUpdated.getRatingsCount() + movie.getRating())
                / (movieToBeUpdated.getRatingsCount() + 1));
        movieToBeUpdated.setRatingsCount(movieToBeUpdated.getRatingsCount() + 1);
    }

}
