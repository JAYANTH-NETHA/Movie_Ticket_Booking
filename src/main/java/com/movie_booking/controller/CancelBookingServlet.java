package com.movie_booking.controller;

import java.io.IOException;

import com.movie_booking.service.BookingService;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/cancelBooking")
public class CancelBookingServlet extends HttpServlet{

    BookingService service=new BookingService();

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException,IOException{

        int bookingId=
        Integer.parseInt(request.getParameter("bookingId"));

        service.cancelBooking(bookingId);

        response.sendRedirect("myBookings");

    }

}