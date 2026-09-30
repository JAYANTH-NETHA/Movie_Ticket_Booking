package com.movie_booking.controller;

import java.io.IOException;

import com.movie_booking.dto.Booking;
import com.movie_booking.dto.User;
import com.movie_booking.service.BookingService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/booking")
public class BookingServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    BookingService service = new BookingService();

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if(session == null || session.getAttribute("currentUser") == null){

            response.sendRedirect("Html/login.html");
            return;

        }

        User user = (User)session.getAttribute("currentUser");

        Booking booking = new Booking();

        booking.setUserId(user.getUserId());

        booking.setShowId(
                Integer.parseInt(request.getParameter("showId")));

        String[] seats = request.getParameterValues("seats");

        if(seats == null){

            response.getWriter().println("Please select at least one seat.");
            return;

        }

        String seatList = String.join(",", seats);

        booking.setSeats(seatList);

        booking.setNumberOfTickets(seats.length);

        double amount = seats.length * 250;

        booking.setTotalAmount(amount);

        int bookingId = service.bookTicket(booking);

        request.setAttribute("bookingId", bookingId);

        request.setAttribute("amount", amount);

        request.getRequestDispatcher("payment.jsp")
                .forward(request, response);

    }

}