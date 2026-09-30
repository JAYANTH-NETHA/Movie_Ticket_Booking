package com.movie_booking.service;

import java.util.List;

import com.movie_booking.dao.BookingDAO;
import com.movie_booking.dto.Booking;

public class BookingService {

    BookingDAO dao = new BookingDAO();

    public int bookTicket(Booking booking) {

        return dao.bookTicket(booking);

    }

    public List<Booking> getBookingsByUserId(int userId) {

        return dao.getBookingsByUserId(userId);

    }

    public int cancelBooking(int bookingId) {

        return dao.cancelBooking(bookingId);

    }

}