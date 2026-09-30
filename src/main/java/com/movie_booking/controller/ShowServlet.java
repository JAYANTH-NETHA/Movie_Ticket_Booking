package com.movie_booking.controller;

import java.io.IOException;
import java.util.List;

import com.movie_booking.dto.Show;
import com.movie_booking.service.ShowService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/shows")
public class ShowServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    ShowService service = new ShowService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int movieId = Integer.parseInt(request.getParameter("movieId"));

        List<Show> shows = service.getShowsByMovieId(movieId);

        request.setAttribute("shows", shows);

        RequestDispatcher dispatcher = request.getRequestDispatcher("shows.jsp");

        dispatcher.forward(request, response);
    }
}