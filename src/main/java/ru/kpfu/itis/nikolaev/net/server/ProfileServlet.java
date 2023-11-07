package ru.kpfu.itis.nikolaev.net.server;

import ru.kpfu.itis.nikolaev.net.util.DatabaseConnectionUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;

import static ru.kpfu.itis.nikolaev.net.server.LoginServlet.login;

@WebServlet(name = "profileServlet", urlPatterns = "/profile")
@MultipartConfig
public class ProfileServlet extends HttpServlet {
    private final Connection connection = DatabaseConnectionUtil.getConnection();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setAttribute("photo", getPhoto());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        req.getRequestDispatcher("profile.ftl").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String newPassword = req.getParameter("newPassword");
        if (newPassword!=null){
            try {
                changePassword(newPassword);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            resp.sendRedirect("/login");
        }
        else{
            req.getRequestDispatcher("profile.ftl").forward(req,resp);
        }


    }



    private void changePassword(String newPassword) throws SQLException {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE schema.users SET password = ? WHERE login = ?");
            statement.setString(1, newPassword);
            statement.setString(2, login);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private String getPhoto() throws SQLException {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM schema.users WHERE login='" + login + "'";
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return resultSet.getString("photo");
            } else {
                throw new RuntimeException("User not found");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}