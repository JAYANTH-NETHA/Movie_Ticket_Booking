package com.movie_booking.controller;

import java.io.IOException;

import com.movie_booking.dto.User;
import com.movie_booking.service.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/userprofile")
public class UserProfileServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    UserService service = new UserService();

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session=request.getSession(false);

        if(session==null){

            response.sendRedirect("Html/login.html");
            return;

        }

        int userId=(Integer)session.getAttribute("userId");

        User user=service.getUserById(userId);

        request.setAttribute("user",user);

        request.getRequestDispatcher("profile.jsp")
        .forward(request,response);

    }

}