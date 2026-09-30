package com.movie_booking.controller;

import java.sql.Date;

import com.movie_booking.dao.UserDAO;
import com.movie_booking.dto.User;

public class TestRegister {

    public static void main(String[] args) {

        User user = new User();

        user.setUserName("Rahul");
        user.setEmail("rahul@gmail.com");
        user.setPassword("rahul@123");
        user.setMobile("9876543210");
        user.setGender("Male");
        user.setDob(Date.valueOf("2002-05-15"));
        user.setAddress("Hyderabad");

        UserDAO dao = new UserDAO();

        int result = dao.registerUser(user);

        if (result > 0) {
            System.out.println("User Registered Successfully");
        } else {
            System.out.println("Registration Failed");
        }
    }
}