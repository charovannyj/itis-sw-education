package ru.kpfu.itis.nikolaev.net.server;

import ru.kpfu.itis.nikolaev.net.model.User;
import ru.kpfu.itis.nikolaev.net.util.DatabaseConnectionUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "loginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private final Connection connection = DatabaseConnectionUtil.getConnection();
    public static String login;
    public static String password;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("login.ftl");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        login = req.getParameter("login");
        password = req.getParameter("password");

        try {
            if (loginIsExist()&&password.equals(getPassword())){
                HttpSession httpSession = req.getSession();
                httpSession.setAttribute("username", login);
                httpSession.setMaxInactiveInterval(60 * 60);

                Cookie cookie = new Cookie("username", login);
                cookie.setMaxAge(24 * 60 * 60);
                resp.addCookie(cookie);




                resp.sendRedirect("profile");
            }
            else{
                doGet(req, resp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private String getPassword() throws SQLException {
        try{
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM schema.users WHERE login='"+login+"'";
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return resultSet.getString("password");
            } else {
                throw new RuntimeException("User not found");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private boolean loginIsExist() throws SQLException {
        try{
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM schema.users WHERE login='"+login+"'";
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}