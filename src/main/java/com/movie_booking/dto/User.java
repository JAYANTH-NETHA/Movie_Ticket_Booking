package com.movie_booking.dto;

import java.sql.Date;

public class User {

    private int userId;
    private String userName;
    private String email;
    private String password;
    private String mobile;
    private String gender;
    private Date dob;
    private String address;

    public User() {
    }

    public User(int userId, String userName, String email, String password,
                String mobile, String gender, Date dob, String address) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.mobile = mobile;
        this.gender = gender;
        this.dob = dob;
        this.address = address;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User [userId=" + userId +
                ", userName=" + userName +
                ", email=" + email +
                ", mobile=" + mobile +
                ", gender=" + gender +
                ", dob=" + dob +
                ", address=" + address + "]";
    }
}