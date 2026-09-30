package com.movie_booking.service;

import java.util.List;

import com.movie_booking.dao.TheatreDAO;
import com.movie_booking.dto.Theatre;

public class TheatreService {

    TheatreDAO theatreDAO = new TheatreDAO();

    public List<Theatre> getAllTheatres() {
        return theatreDAO.getAllTheatres();
    }

}