package com.movie_booking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.movie_booking.dto.Movie;
import com.movie_booking.util.DBConnection;

public class MovieDAO {

    Connection connection = DBConnection.getConnection();
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    public List<Movie> getAllMovies() {

        List<Movie> movies = new ArrayList<>();

        String selectQuery = "SELECT * FROM movies";

        try {

            preparedStatement = connection.prepareStatement(selectQuery);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                Movie movie = new Movie();

                movie.setMovieId(resultSet.getInt("movie_id"));
                movie.setMovieName(resultSet.getString("movie_name"));
                movie.setGenre(resultSet.getString("genre"));
                movie.setLanguage(resultSet.getString("language"));
                movie.setDuration(resultSet.getString("duration"));
                movie.setCensor(resultSet.getString("censor"));
                movie.setReleaseDate(resultSet.getDate("release_date"));
                movie.setRating(resultSet.getDouble("rating"));
                movie.setCast(resultSet.getString("cast"));
                movie.setDescription(resultSet.getString("description"));
                movie.setPoster(resultSet.getString("poster"));
                movie.setTrailer(resultSet.getString("trailer"));

                movies.add(movie);
            }
            System.out.println("Movies Loaded = " + movies.size());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return movies;
    }
    public Movie getMovieById(int movieId) {

        Movie movie = null;

        String query = "SELECT * FROM movies WHERE movie_id=?";

        try {

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, movieId);

            resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){

                movie = new Movie();

                movie.setMovieId(resultSet.getInt("movie_id"));
                movie.setMovieName(resultSet.getString("movie_name"));
                movie.setGenre(resultSet.getString("genre"));
                movie.setLanguage(resultSet.getString("language"));
                movie.setDuration(resultSet.getString("duration"));
                movie.setCensor(resultSet.getString("censor"));
                movie.setReleaseDate(resultSet.getDate("release_date"));
                movie.setRating(resultSet.getDouble("rating"));
                movie.setCast(resultSet.getString("cast"));
                movie.setDescription(resultSet.getString("description"));
                movie.setPoster(resultSet.getString("poster"));
                movie.setTrailer(resultSet.getString("trailer"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return movie;
    }
}
