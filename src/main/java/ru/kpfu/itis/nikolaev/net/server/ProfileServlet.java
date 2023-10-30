package ru.kpfu.itis.nikolaev.net.server;

import ru.kpfu.itis.nikolaev.net.util.DatabaseConnectionUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;

@WebServlet(name = "profileServlet", urlPatterns = "/profile")

public class ProfileServlet extends HttpServlet {
    private final Connection connection = DatabaseConnectionUtil.getConnection();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("profile.ftl");
        //resp.getWriter().println(req.getSession().getAttribute("position"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String newPassword = req.getParameter("newPassword");
        /*Part photoPart = req.getPart("newPhoto");
        InputStream photoStream = photoPart.getInputStream();*/
        try {
            changePassword(newPassword);
            //addPhoto(photoStream);
            resp.sendRedirect("/login");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void addPhoto(InputStream photoStream) throws SQLException {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE schema.users SET photo = ? WHERE login = ?");
            statement.setBinaryStream(1, photoStream);
            statement.setString(2, LoginServlet.login);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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