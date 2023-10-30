package ru.kpfu.itis.nikolaev.net.server;

import ru.kpfu.itis.nikolaev.net.util.DatabaseConnectionUtil;

import java.time.LocalDate;
import java.time.LocalTime;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;

@WebServlet(name = "mainServlet", urlPatterns = "/main")

public class MainServlet extends HttpServlet {
    private final Connection connection = DatabaseConnectionUtil.getConnection();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("main.ftl");
        //resp.getWriter().println(req.getSession().getAttribute("position"));
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //String[] messages = request.getParameterValues("message");
        int id = generateId();
        String login = req.getSession().getAttribute("login").toString();
        String time = LocalDate.now() + " " + String.valueOf(LocalTime.now()).substring(0,8);
        String content = req.getParameter("message");
        addInfoInForum(id, login, time, content);
    }

    public void addInfoInForum(int id, String login, String time, String content) {
        String query = "INSERT INTO schema.forum (id, login_user, time, content) VALUES (?, ?, ?, ?);";
        try (PreparedStatement preparedStatement = DatabaseConnectionUtil.getConnection().prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, login);
            preparedStatement.setString(3, time);
            preparedStatement.setString(4, content);
            preparedStatement.execute();
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    private int generateId() {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT MAX(id) FROM schema.forum";
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return resultSet.getInt(1) + 1;
            } else {
                return 0;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}