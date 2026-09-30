package com.movie_booking.service;

import com.movie_booking.dao.PaymentDAO;
import com.movie_booking.dto.Payment;

public class PaymentService {

    PaymentDAO dao=new PaymentDAO();

    public int savePayment(Payment payment){

        return dao.savePayment(payment);

    }

}