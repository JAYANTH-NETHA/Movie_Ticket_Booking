package com.movie_booking.controller;

import java.io.IOException;
import java.util.List;

import com.movie_booking.dto.Booking;
import com.movie_booking.dto.User;
import com.movie_booking.service.BookingService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/myBookings")
public class MyBookingsServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    BookingService service = new BookingService();

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session=request.getSession(false);

        if(session==null){

            response.sendRedirect("Html/login.html");
            return;

        }

        User user=(User)session.getAttribute("currentUser");

        List<Booking> bookings=
                service.getBookingsByUserId(user.getUserId());

        request.setAttribute("bookings",bookings);

        request.getRequestDispatcher("myBookings.jsp")
                .forward(request,response);

    }

}