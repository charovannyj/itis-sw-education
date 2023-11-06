package ru.kpfu.itis.nikolaev.net.dao.impl;

import ru.kpfu.itis.nikolaev.net.dao.Dao;
import ru.kpfu.itis.nikolaev.net.model.Rating;
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
            String sql = "SELECT * from schema.ratings ORDER BY id DESC";
            ResultSet resultSet = statement.executeQuery(sql);
            List<Rating> ratings = new ArrayList<>();
            if (resultSet != null) {
                while (resultSet.next()) {
                    ratings.add(
                            new Rating(
                                    resultSet.getInt("id"),
                                    resultSet.getString("login_user"),
                                    resultSet.getString("grade"),
                                    resultSet.getString("subject"),
                                    resultSet.getString("area"),
                                    resultSet.getString("teacher"),
                                    resultSet.getString("content")
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
        String query = "INSERT INTO schema.ratings (id, login_user, grade, subject, area, teacher, content) VALUES (?, ?, ?, ?, ?, ?, ?);";
        try (PreparedStatement preparedStatement = DatabaseConnectionUtil.getConnection().prepareStatement(query)) {
            preparedStatement.setInt(1, rating.getId());
            preparedStatement.setString(2, rating.getLogin_user());
            preparedStatement.setString(3, rating.getGrade());
            preparedStatement.setString(4, rating.getSubject());
            preparedStatement.setString(5, rating.getArea());
            preparedStatement.setString(6, rating.getTeacher());
            preparedStatement.setString(7, rating.getContent());
            preparedStatement.execute();
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }
}
