package com.movie_booking.controller;

import java.util.List;

import com.movie_booking.dto.Theatre;
import com.movie_booking.service.TheatreService;

public class TheatreController {

    public static void main(String[] args) {

        TheatreService theatreService = new TheatreService();

        List<Theatre> theatres = theatreService.getAllTheatres();

        for (Theatre theatre : theatres) {

            System.out.println("------------------------------");
            System.out.println("Theatre ID   : " + theatre.getTheatreId());
            System.out.println("Theatre Name : " + theatre.getTheatreName());
            System.out.println("Location     : " + theatre.getLocation());
            System.out.println("Screen Type  : " + theatre.getScreenType());
            System.out.println("Total Seats  : " + theatre.getTotalSeats());
            System.out.println("------------------------------");
        }
    }
}