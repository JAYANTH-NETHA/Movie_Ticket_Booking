package com.movie_booking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.movie_booking.dto.Show;
import com.movie_booking.util.DBConnection;

public class ShowDAO {

    Connection connection = DBConnection.getConnection();

    // =======================
    // Get All Shows
    // =======================

    public List<Show> getAllShows() {

        List<Show> list = new ArrayList<>();

        try {

            String query = "SELECT * FROM shows";

            PreparedStatement ps = connection.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Show show = new Show();

                show.setShowId(rs.getInt("show_id"));
                show.setMovieId(rs.getInt("movie_id"));
                show.setTheatreId(rs.getInt("theatre_id"));
                show.setShowDate(rs.getDate("show_date"));
                show.setShowTime(rs.getTime("show_time"));
                show.setTicketPrice(rs.getDouble("ticket_price"));

                list.add(show);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // =======================
    // Get Shows By Movie Id
    // =======================

    public List<Show> getShowsByMovieId(int movieId) {

        List<Show> list = new ArrayList<>();

        try {

            String query =
                    "SELECT s.show_id,s.movie_id,s.theatre_id,"
                  + "t.theatre_name,t.location,t.screen_type,"
                  + "s.show_date,s.show_time,s.ticket_price "
                  + "FROM shows s "
                  + "JOIN theatres t ON s.theatre_id=t.theatre_id "
                  + "WHERE s.movie_id=? "
                  + "ORDER BY t.theatre_name,s.show_time";

            PreparedStatement ps = connection.prepareStatement(query);

            ps.setInt(1, movieId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Show show = new Show();

                show.setShowId(rs.getInt("show_id"));
                show.setMovieId(rs.getInt("movie_id"));
                show.setTheatreId(rs.getInt("theatre_id"));
                show.setTheatreName(rs.getString("theatre_name"));
                show.setLocation(rs.getString("location"));
                show.setScreenType(rs.getString("screen_type"));
                show.setShowDate(rs.getDate("show_date"));
                show.setShowTime(rs.getTime("show_time"));
                show.setTicketPrice(rs.getDouble("ticket_price"));

                list.add(show);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}