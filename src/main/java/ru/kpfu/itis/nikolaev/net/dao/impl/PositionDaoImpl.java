package ru.kpfu.itis.nikolaev.net.dao.impl;

import ru.kpfu.itis.nikolaev.net.dao.Dao;
import ru.kpfu.itis.nikolaev.net.model.Forum;
import ru.kpfu.itis.nikolaev.net.model.Position;
import ru.kpfu.itis.nikolaev.net.model.User;
import ru.kpfu.itis.nikolaev.net.util.DatabaseConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PositionDaoImpl implements Dao<Position> {
    private final Connection connection = DatabaseConnectionUtil.getConnection();
    @Override
    public Position get(int id) {
        return null;
    }

    @Override
    public List<Position> getAll() {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * from schema.position";
            ResultSet resultSet = statement.executeQuery(sql);
            List<Position> positions = new ArrayList<>();
            if (resultSet != null) {
                while (resultSet.next()) {
                    positions.add(
                            new Position(
                                    resultSet.getInt("id"),
                                    resultSet.getString("position"),
                                    resultSet.getString("content")
                            )
                    );
                }
            }
            return positions;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Position position) {
        String query = "INSERT INTO schema.position (id, time, content) VALUES (?, ?, ?);";
        try (PreparedStatement preparedStatement = DatabaseConnectionUtil.getConnection().prepareStatement(query)) {
            preparedStatement.setInt(1, position.getId());
            preparedStatement.setString(2, position.getPosition());
            preparedStatement.setString(3, position.getPossibilities());
            preparedStatement.execute();
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }
}
