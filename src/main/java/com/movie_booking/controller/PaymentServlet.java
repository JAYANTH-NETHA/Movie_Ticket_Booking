package com.movie_booking.controller;

import java.io.IOException;

import com.movie_booking.dto.Payment;
import com.movie_booking.service.PaymentService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/payment")
public class PaymentServlet extends HttpServlet{

    PaymentService service=new PaymentService();

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException,IOException{

        Payment payment=new Payment();

        payment.setBookingId(
        Integer.parseInt(request.getParameter("bookingId")));

        payment.setPaymentMethod(
        request.getParameter("paymentMethod"));

        payment.setCouponCode(
        request.getParameter("couponCode"));

        payment.setAmountPaid(
        Double.parseDouble(request.getParameter("amount")));

        service.savePayment(payment);

        request.setAttribute("bookingId",
        payment.getBookingId());

        request.getRequestDispatcher("bookingSuccess.jsp")
        .forward(request,response);

    }

}