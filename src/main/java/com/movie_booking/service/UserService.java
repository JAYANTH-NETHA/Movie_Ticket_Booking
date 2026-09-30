package com.movie_booking.service;

import com.movie_booking.dao.UserDAO;
import com.movie_booking.dto.User;

public class UserService {

    UserDAO userDAO = new UserDAO();

    public int registerUser(User user) {
        return userDAO.registerUser(user);
    }

    public User loginUser(String email, String password) {
        return userDAO.loginUser(email, password);
    }

    public User getUserById(int userId) {
        return userDAO.getUserById(userId);
    }
}