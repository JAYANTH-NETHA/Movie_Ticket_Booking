package com.movie_booking.controller;

import java.sql.Date;
import java.util.Scanner;

import com.movie_booking.dao.UserDAO;
import com.movie_booking.dto.User;

public class UserController {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        UserDAO userDAO = new UserDAO();

        while (true) {

            System.out.println("\n===== MOVIE TICKET BOOKING =====");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

            case 1:

                User user = new User();

                System.out.print("Enter Name: ");
                user.setUserName(sc.nextLine());

                System.out.print("Enter Email: ");
                user.setEmail(sc.nextLine());

                System.out.print("Enter Password: ");
                user.setPassword(sc.nextLine());

                System.out.print("Enter Mobile: ");
                user.setMobile(sc.nextLine());

                System.out.print("Enter Gender: ");
                user.setGender(sc.nextLine());

                System.out.print("Enter DOB (yyyy-mm-dd): ");
                user.setDob(Date.valueOf(sc.nextLine()));

                System.out.print("Enter Address: ");
                user.setAddress(sc.nextLine());

                int result = userDAO.registerUser(user);

                if (result > 0) {
                    System.out.println("Registration Successful");
                } else {
                    System.out.println("Registration Failed");
                }

                break;

            case 2:

                System.out.print("Enter Email: ");
                String email = sc.nextLine();

                System.out.print("Enter Password: ");
                String password = sc.nextLine();

                User loggedInUser = userDAO.loginUser(email, password);

                if (loggedInUser != null) {
                    System.out.println("\nLogin Successful");
                    System.out.println("Welcome " + loggedInUser.getUserName());
                } else {
                    System.out.println("Invalid Email or Password");
                }

                break;

            case 3:

                System.out.println("Thank You");
                sc.close();
                System.exit(0);

            default:

                System.out.println("Invalid Choice");

            }

        }

    }

}