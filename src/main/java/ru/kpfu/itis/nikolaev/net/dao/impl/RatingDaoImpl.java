package ru.kpfu.itis.nikolaev.net.dao.impl;

import ru.kpfu.itis.nikolaev.net.dao.Dao;
import ru.kpfu.itis.nikolaev.net.model.Forum;
import ru.kpfu.itis.nikolaev.net.model.Rating;
import ru.kpfu.itis.nikolaev.net.model.User;
import ru.kpfu.itis.nikolaev.net.util.DatabaseConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RatingDaoImpl implements Dao<Rating> {
    private final Connection connection = DatabaseConnectionUtil.getConnection();
    @Override
    public Rating get(int id) {
        return null;
    }

    @Override
    public List<Rating> getAll() {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * from schema.ratings";
            ResultSet resultSet = statement.executeQuery(sql);
            List<Rating> ratings = new ArrayList<>();
            if (resultSet != null) {
                while (resultSet.next()) {
                    ratings.add(
                            new Rating(
                                    resultSet.getInt("id"),
                                    resultSet.getInt("id_user"),
                                    resultSet.getString("course"),
                                    resultSet.getString("teacher"),
                                    resultSet.getString("content"),
                                    resultSet.getInt("grade")
                                    )
                    );
                }
            }
            return ratings;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Rating rating) {
        String query = "INSERT INTO schema.ratings (id, id_user, course, teacher, content, grade) VALUES (?, ?, ?, ?, ?, ?);";
        try (PreparedStatement preparedStatement = DatabaseConnectionUtil.getConnection().prepareStatement(query)) {
            preparedStatement.setInt(1, rating.getId());
            preparedStatement.setInt(2, rating.getId_user());
            preparedStatement.setString(3, rating.getCourse());
            preparedStatement.setString(4, rating.getTeacher());
            preparedStatement.setString(5, rating.getContent());
            preparedStatement.setInt(6, rating.getGrade());
            preparedStatement.execute();
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }
}
