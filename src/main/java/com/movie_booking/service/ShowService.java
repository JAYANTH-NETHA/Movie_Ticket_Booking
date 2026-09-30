package com.movie_booking.service;

import java.util.List;

import com.movie_booking.dao.ShowDAO;
import com.movie_booking.dto.Show;

public class ShowService {

    ShowDAO dao = new ShowDAO();

    public List<Show> getAllShows() {
        return dao.getAllShows();
    }

    public List<Show> getShowsByMovieId(int movieId) {
        return dao.getShowsByMovieId(movieId);
    }
}