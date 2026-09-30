package com.movie_booking.controller;

import java.io.IOException;

import com.movie_booking.dto.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session == null) {
            response.sendRedirect("Html/login.html");
            return;
        }

        User user = (User) session.getAttribute("currentUser");

        if (user == null) {
            response.sendRedirect("Html/login.html");
            return;
        }

        request.setAttribute("user", user);

        request.getRequestDispatcher("profile.jsp")
               .forward(request, response);
    }
}