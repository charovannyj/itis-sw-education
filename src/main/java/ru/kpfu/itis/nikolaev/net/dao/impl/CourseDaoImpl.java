package ru.kpfu.itis.nikolaev.net.dao.impl;

import ru.kpfu.itis.nikolaev.net.dao.Dao;
import ru.kpfu.itis.nikolaev.net.model.Course;
import ru.kpfu.itis.nikolaev.net.model.Forum;
import ru.kpfu.itis.nikolaev.net.model.User;
import ru.kpfu.itis.nikolaev.net.util.DatabaseConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDaoImpl implements Dao<Course> {
    private final Connection connection = DatabaseConnectionUtil.getConnection();
    @Override
    public Course get(int id) {
        return null;
    }

    @Override
    public List<Course> getAll() {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * from schema.courses";
            ResultSet resultSet = statement.executeQuery(sql);
            List<Course> courses = new ArrayList<>();
            if (resultSet != null) {
                while (resultSet.next()) {
                    courses.add(
                            new Course(
                                    resultSet.getInt("id"),
                                    resultSet.getString("name"),
                                    resultSet.getInt("price"),
                                    resultSet.getInt("duration"),
                                    resultSet.getString("subject"),
                                    resultSet.getString("area")
                            )
                    );
                }
            }
            return courses;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Course course) {
        String query = "INSERT INTO schema.courses (id, name, price, duration,subject,area) VALUES (?, ?, ?, ?, ?, ?);";
        try (PreparedStatement preparedStatement = DatabaseConnectionUtil.getConnection().prepareStatement(query)) {
            preparedStatement.setInt(1, course.getId());
            preparedStatement.setString(2, course.getName());
            preparedStatement.setInt(3, course.getPrice());
            preparedStatement.setInt(4, course.getDuration());
            preparedStatement.setString(5, course.getSubject());
            preparedStatement.setString(6, course.getArea());
            preparedStatement.execute();
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }
}
