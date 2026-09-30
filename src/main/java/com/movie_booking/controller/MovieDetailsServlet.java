package com.movie_booking.controller;

import java.io.IOException;

import com.movie_booking.dto.Movie;
import com.movie_booking.service.MovieService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/movieDetails")
public class MovieDetailsServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    MovieService movieService = new MovieService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get movie id from URL
        int movieId = Integer.parseInt(request.getParameter("id"));

        // Fetch movie from database
        Movie movie = movieService.getMovieById(movieId);

        // Send movie to JSP
        request.setAttribute("movie", movie);

        // Open movieDetails.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("movieDetails.jsp");
        dispatcher.forward(request, response);
    }
}