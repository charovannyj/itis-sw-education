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
    public static String name;
    public static String login;
    public static String date;
    public static String password;
    public static String gender;
    public static String position;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("login.ftl");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        login = req.getParameter("login");
        password = req.getParameter("password");
        try {
            if (loginIsExist() && password.equals(getPassword())) {
                setAttributes(httpSession);
                httpSession.setMaxInactiveInterval(60 * 60);

                Cookie cookie = new Cookie("login", getLogin());
                cookie.setMaxAge(24 * 60 * 60);
                resp.addCookie(cookie);

                resp.sendRedirect("main");
            } else {
                doGet(req, resp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private void setAttributes(HttpSession httpSession) throws SQLException {
        httpSession.setAttribute("id",getId());
        httpSession.setAttribute("login", getLogin());
        httpSession.setAttribute("password", getPassword());
        httpSession.setAttribute("date", getDate());
        httpSession.setAttribute("gender", getGender());
        httpSession.setAttribute("name", getName());
        httpSession.setAttribute("position", getPosition());
    }
    private boolean loginIsExist() throws SQLException {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM schema.users WHERE login='" + getLogin() + "'";
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
    private String getId() throws SQLException {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM schema.users WHERE login='" + getLogin() + "'";
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return resultSet.getString("id");
            } else {
                throw new RuntimeException("User not found");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private String getName() throws SQLException {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM schema.users WHERE login='" + getLogin() + "'";
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return resultSet.getString("name");
            } else {
                throw new RuntimeException("User not found");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private String getLogin() {
        return login;
    }

    private String getDate() throws SQLException {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM schema.users WHERE login='" + getLogin() + "'";
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return resultSet.getString("date");
            } else {
                throw new RuntimeException("User not found");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private String getPassword() throws SQLException {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM schema.users WHERE login='" + getLogin() + "'";
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

    private String getGender() throws SQLException {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM schema.users WHERE login='" + getLogin() + "'";
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return resultSet.getString("gender");
            } else {
                throw new RuntimeException("User not found");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private String getPosition() throws SQLException {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM schema.users WHERE login='" + getLogin() + "'";
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return resultSet.getString("position");
            } else {
                throw new RuntimeException("User not found");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}