package com.movie_booking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.movie_booking.dto.Booking;
import com.movie_booking.util.DBConnection;

public class BookingDAO {

    Connection connection = DBConnection.getConnection();

    // Save Booking
    public int bookTicket(Booking booking) {

        int bookingId = 0;

        try {

            String sql = "INSERT INTO bookings(user_id,show_id,seats,number_of_tickets,total_amount) VALUES(?,?,?,?,?)";

            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, booking.getUserId());
            ps.setInt(2, booking.getShowId());
            ps.setString(3, booking.getSeats());
            ps.setInt(4, booking.getNumberOfTickets());
            ps.setDouble(5, booking.getTotalAmount());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {

                bookingId = rs.getInt(1);

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return bookingId;

    }

    // View Bookings of Logged-in User
    public List<Booking> getBookingsByUserId(int userId) {

        List<Booking> bookings = new ArrayList<>();

        try {

            String sql = "SELECT * FROM bookings WHERE user_id=? ORDER BY booking_date DESC";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Booking booking = new Booking();

                booking.setBookingId(rs.getInt("booking_id"));
                booking.setUserId(rs.getInt("user_id"));
                booking.setShowId(rs.getInt("show_id"));
                booking.setSeats(rs.getString("seats"));
                booking.setNumberOfTickets(rs.getInt("number_of_tickets"));
                booking.setTotalAmount(rs.getDouble("total_amount"));
                booking.setBookingDate(rs.getTimestamp("booking_date"));
                booking.setBookingStatus(rs.getString("booking_status"));

                bookings.add(booking);

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return bookings;

    }

    // Cancel Booking
    public int cancelBooking(int bookingId) {

        try {

            String sql = "UPDATE bookings SET booking_status='Cancelled' WHERE booking_id=?";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, bookingId);

            return ps.executeUpdate();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return 0;

    }

}