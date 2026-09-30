package com.movie_booking.controller;

import java.io.IOException;
import java.util.List;

import com.movie_booking.dto.Movie;
import com.movie_booking.service.MovieService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/movies")
public class MovieServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	MovieService movieService = new MovieService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Fetch all movies from database
		List<Movie> movies = movieService.getAllMovies();
		System.out.println("Movies found = " + movies.size());

		// Store the list inside request
		request.setAttribute("movies", movies);

		// Forward to JSP
		RequestDispatcher dispatcher = request.getRequestDispatcher("movie.jsp");
		dispatcher.forward(request, response);
	}

}