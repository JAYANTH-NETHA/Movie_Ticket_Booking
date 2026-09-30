package com.movie_booking.service;

import java.util.List;

import com.movie_booking.dao.MovieDAO;
import com.movie_booking.dto.Movie;

public class MovieService {

    MovieDAO movieDAO = new MovieDAO();

    public List<Movie> getAllMovies() {
        return movieDAO.getAllMovies();
    }
    public Movie getMovieById(int movieId) {
        return movieDAO.getMovieById(movieId);
    }

}