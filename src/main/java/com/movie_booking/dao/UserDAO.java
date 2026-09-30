package com.movie_booking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.movie_booking.dto.User;
import com.movie_booking.util.DBConnection;

public class UserDAO {

    Connection connection = DBConnection.getConnection();
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    
    public int registerUser(User user) {

        String insertQuery = "INSERT INTO users(user_name, email, password, mobile, gender, dob, address) VALUES(?,?,?,?,?,?,?)";

        try {
            preparedStatement = connection.prepareStatement(insertQuery);

            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getMobile());
            preparedStatement.setString(5, user.getGender());
            preparedStatement.setDate(6, user.getDob());
            preparedStatement.setString(7, user.getAddress());

            return preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }
    public User loginUser(String email, String password) {

        String selectQuery =
                "SELECT * FROM users WHERE email=? AND password=?";

        try {

            preparedStatement = connection.prepareStatement(selectQuery);

            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {

                User user = new User();

                user.setUserId(resultSet.getInt("user_id"));
                user.setUserName(resultSet.getString("user_name"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setMobile(resultSet.getString("mobile"));
                user.setGender(resultSet.getString("gender"));
                user.setDob(resultSet.getDate("dob"));
                user.setAddress(resultSet.getString("address"));

                return user;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
    public User getUserById(int userId){

        User user=null;

        try{

            String sql="select * from users where user_id=?";

            PreparedStatement ps=connection.prepareStatement(sql);

            ps.setInt(1,userId);

            ResultSet rs=ps.executeQuery();

            if(rs.next()){

                user=new User();

                user.setUserId(rs.getInt("user_id"));
                user.setUserName(rs.getString("user_name"));
                user.setEmail(rs.getString("email"));
                user.setMobile(rs.getString("mobile"));
                user.setGender(rs.getString("gender"));
                user.setDob(rs.getDate("dob"));
                user.setAddress(rs.getString("address"));

            }

        }

        catch(Exception e){

            e.printStackTrace();

        }

        return user;

    }

}
