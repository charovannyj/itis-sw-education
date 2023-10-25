package ru.kpfu.itis.nikolaev.net.dao.impl;

import ru.kpfu.itis.nikolaev.net.dao.Dao;
import ru.kpfu.itis.nikolaev.net.model.User;
import ru.kpfu.itis.nikolaev.net.util.DatabaseConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements Dao<User> {

    private final Connection connection = DatabaseConnectionUtil.getConnection();

    @Override
    public User get(int id) {
        return null;
    }

    @Override
    public List<User> getAll() {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * from users";
            ResultSet resultSet = statement.executeQuery(sql);
            List<User> users = new ArrayList<>();
            if (resultSet != null) {
                while (resultSet.next()) {
                    users.add(
                            new User(
                                    resultSet.getInt("id"),
                                    resultSet.getString("name"),
                                    resultSet.getString("login"),
                                    resultSet.getDate("date"),
                                    resultSet.getString("password"),
                                    resultSet.getString("gender"),
                                    resultSet.getString("position")
                            )
                    );
                }
            }
            return users;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(User user) {
        String sql = "insert into users (id, name, login, date, password, gender, position) values (?, ?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getLogin());
            preparedStatement.setDate(4, (Date) user.getDate());
            preparedStatement.setString(5, user.getPassword());
            preparedStatement.setString(6, user.getGender());
            preparedStatement.setString(7, user.getPosition());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}