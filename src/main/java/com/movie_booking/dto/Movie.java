package com.movie_booking.dto;

import java.sql.Date;

public class Movie {

    private int movieId;
    private String movieName;
    private String genre;
    private String language;
    private String duration;
    private String censor;
    private Date releaseDate;
    private double rating;
    private String cast;
    private String description;
    private String poster;
    private String trailer;

    public Movie() {
    }

    public Movie(int movieId, String movieName, String genre, String language,
            String duration, String censor, Date releaseDate,
            double rating, String cast, String description,
            String poster, String trailer) {

        this.movieId = movieId;
        this.movieName = movieName;
        this.genre = genre;
        this.language = language;
        this.duration = duration;
        this.censor = censor;
        this.releaseDate = releaseDate;
        this.rating = rating;
        this.cast = cast;
        this.description = description;
        this.poster = poster;
        this.trailer = trailer;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getCensor() {
        return censor;
    }

    public void setCensor(String censor) {
        this.censor = censor;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

}