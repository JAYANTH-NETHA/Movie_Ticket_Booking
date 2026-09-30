package com.movie_booking.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/seatSelection")
public class SeatServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int showId =
                Integer.parseInt(request.getParameter("showId"));

        request.setAttribute("showId", showId);

        request.getRequestDispatcher("seatSelection.jsp")
                .forward(request, response);

    }

}