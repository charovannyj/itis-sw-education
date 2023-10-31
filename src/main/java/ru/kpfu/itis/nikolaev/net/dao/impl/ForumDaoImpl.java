package ru.kpfu.itis.nikolaev.net.dao.impl;

import ru.kpfu.itis.nikolaev.net.dao.Dao;
import ru.kpfu.itis.nikolaev.net.model.Forum;
import ru.kpfu.itis.nikolaev.net.model.User;
import ru.kpfu.itis.nikolaev.net.util.DatabaseConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ForumDaoImpl implements Dao<Forum> {
    private final Connection connection = DatabaseConnectionUtil.getConnection();
    @Override
    public Forum get(int id) {
        return null;
    }

    @Override
    public List<Forum> getAll() {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * from schema.forum ORDER BY id DESC";
            ResultSet resultSet = statement.executeQuery(sql);
            List<Forum> forums = new ArrayList<>();
            if (resultSet != null) {
                while (resultSet.next()) {
                    forums.add(
                            new Forum(
                                    resultSet.getInt("id"),
                                    resultSet.getString("login_user"),
                                    resultSet.getString("time"),
                                    resultSet.getString("content")
                            )
                    );
                }
            }
            return forums;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Forum forum) {
        String query = "INSERT INTO schema.forum (id, login_user, time, content) VALUES (?, ?, ?, ?);";
        try (PreparedStatement preparedStatement = DatabaseConnectionUtil.getConnection().prepareStatement(query)) {
            preparedStatement.setInt(1, forum.getId());
            preparedStatement.setString(2, forum.getLogin_user());
            preparedStatement.setString(3, forum.getTime());
            preparedStatement.setString(4, forum.getContent());
            preparedStatement.execute();
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }
}
