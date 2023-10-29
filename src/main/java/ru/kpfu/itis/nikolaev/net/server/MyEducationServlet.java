package ru.kpfu.itis.nikolaev.net.server;

import ru.kpfu.itis.nikolaev.net.util.DatabaseConnectionUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "educationServlet", urlPatterns = "/education")

public class MyEducationServlet extends HttpServlet {
    private final Connection connection = DatabaseConnectionUtil.getConnection();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("myeducation.ftl");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
    private void changePassword(String newPassword) throws SQLException {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE schema.users SET password = ? WHERE login = ?");
            statement.setString(1, newPassword);
            statement.setString(2, LoginServlet.login);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}