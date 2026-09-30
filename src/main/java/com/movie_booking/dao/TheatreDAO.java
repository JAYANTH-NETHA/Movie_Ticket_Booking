package com.movie_booking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.movie_booking.dto.Theatre;
import com.movie_booking.util.DBConnection;

public class TheatreDAO {

    Connection connection = DBConnection.getConnection();
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    public List<Theatre> getAllTheatres() {

        List<Theatre> theatres = new ArrayList<>();

        String selectQuery = "SELECT * FROM theatres";

        try {

            preparedStatement = connection.prepareStatement(selectQuery);

            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {

                Theatre theatre = new Theatre();

                theatre.setTheatreId(resultSet.getInt("theatre_id"));
                theatre.setTheatreName(resultSet.getString("theatre_name"));
                theatre.setLocation(resultSet.getString("location"));
                theatre.setScreenType(resultSet.getString("screen_type"));
                theatre.setTotalSeats(resultSet.getInt("total_seats"));

                theatres.add(theatre);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return theatres;
    }

}