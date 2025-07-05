package com.LLD.LLD.BookMyShow;

import java.util.Map;

public class Movie {

    private String movieId;

    private String movieName;

    private String genre;

    private Double rating;

    private Integer ratingsCount;

    private Map<String,String> details;

    public Movie(String movieId, String movieName, String genre, Map<String, String> details) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.genre = genre;
        this.details = details;
        this.ratingsCount = 0;
        this.rating = 0.0;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Map<String, String> getDetails() {
        return details;
    }

    public void setDetails(Map<String, String> details) {
        this.details = details;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getRatingsCount() {
        return ratingsCount;
    }

    public void setRatingsCount(Integer ratingsCount) {
        this.ratingsCount = ratingsCount;
    }
}
