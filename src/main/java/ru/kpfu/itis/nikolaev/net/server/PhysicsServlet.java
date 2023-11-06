package ru.kpfu.itis.nikolaev.net.server;

import ru.kpfu.itis.nikolaev.net.util.DatabaseConnectionUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "physicsServlet", urlPatterns = "/physics")

public class PhysicsServlet extends HttpServlet {
    private String subject = "Физика";
    private final Connection connection = DatabaseConnectionUtil.getConnection();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List names = getNames();
        List areas = getAreas();
        List contents = getContents();
        List photos = getPhotos();
        req.setAttribute("subject", subject);
        req.setAttribute("names", names);
        req.setAttribute("areas", areas);
        req.setAttribute("contents", contents);
        req.setAttribute("photos", photos);

        req.getRequestDispatcher("physics.ftl").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
    private List<String> getNames(){
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM schema.teachers WHERE subject='" + subject + "'";
            ResultSet resultSet = statement.executeQuery(sql);
            List<String> names = new ArrayList<>();
            if (resultSet != null) {
                while (resultSet.next()) {
                    names.add(resultSet.getString("name")
                    );
                }
            }
            return names;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private List<String> getAreas(){
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM schema.teachers WHERE subject='" + subject + "'";
            ResultSet resultSet = statement.executeQuery(sql);
            List<String> names = new ArrayList<>();
            if (resultSet != null) {
                while (resultSet.next()) {
                    names.add(resultSet.getString("area")
                    );
                }
            }
            return names;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private List<String> getContents(){
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM schema.teachers WHERE subject='" + subject + "'";
            ResultSet resultSet = statement.executeQuery(sql);
            List<String> names = new ArrayList<>();
            if (resultSet != null) {
                while (resultSet.next()) {
                    names.add(resultSet.getString("content")
                    );
                }
            }
            return names;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private List<String> getPhotos(){
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM schema.teachers WHERE subject='" + subject + "'";
            ResultSet resultSet = statement.executeQuery(sql);
            List<String> names = new ArrayList<>();
            if (resultSet != null) {
                while (resultSet.next()) {
                    names.add(resultSet.getString("photo")
                    );
                }
            }
            return names;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}