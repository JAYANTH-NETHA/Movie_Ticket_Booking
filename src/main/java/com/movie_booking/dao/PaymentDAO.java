package com.movie_booking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.movie_booking.dto.Payment;
import com.movie_booking.util.DBConnection;

public class PaymentDAO {

    Connection connection = DBConnection.getConnection();

    public int savePayment(Payment payment) {

        String sql="insert into payments(booking_id,payment_method,coupon_code,amount_paid,payment_status) values(?,?,?,?,?)";

        try {

            PreparedStatement ps=connection.prepareStatement(sql);

            ps.setInt(1,payment.getBookingId());
            ps.setString(2,payment.getPaymentMethod());
            ps.setString(3,payment.getCouponCode());
            ps.setDouble(4,payment.getAmountPaid());
            ps.setString(5,"Success");

            return ps.executeUpdate();

        } catch(Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

}