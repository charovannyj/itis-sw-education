package ru.kpfu.itis.nikolaev.net.dao.impl;

import ru.kpfu.itis.nikolaev.net.dao.Dao;
import ru.kpfu.itis.nikolaev.net.model.Teacher;
import ru.kpfu.itis.nikolaev.net.model.User;
import ru.kpfu.itis.nikolaev.net.util.DatabaseConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeacherDaoImpl implements Dao<Teacher> {

    private final Connection connection = DatabaseConnectionUtil.getConnection();

    @Override
    public Teacher get(int id) {
        return null;
    }

    @Override
    public List<Teacher> getAll() {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * from schema.teachers";
            ResultSet resultSet = statement.executeQuery(sql);
            List<Teacher> teachers = new ArrayList<>();
            if (resultSet != null) {
                while (resultSet.next()) {
                    teachers.add(
                            new Teacher(
                                    resultSet.getInt("id"),
                                    resultSet.getString("subject"),
                                    resultSet.getString("area"),
                                    resultSet.getString("content"),
                                    resultSet.getString("photo"),
                                    resultSet.getString("name")
                            )
                    );
                }
            }
            return teachers;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Teacher teacher) {
        String sql = "insert into schema.teachers (id, subject, area, content, photo, name) values (?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, teacher.getId());
            preparedStatement.setString(2, teacher.getSubject());
            preparedStatement.setString(3, teacher.getArea());
            preparedStatement.setString(4, teacher.getContent());
            preparedStatement.setString(5, teacher.getPhoto());
            preparedStatement.setString(6, teacher.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}