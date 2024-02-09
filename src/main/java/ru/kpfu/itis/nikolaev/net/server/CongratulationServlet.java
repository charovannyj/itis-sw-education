package ru.kpfu.itis.nikolaev.net.server;

import ru.kpfu.itis.nikolaev.net.dao.Dao;
import ru.kpfu.itis.nikolaev.net.model.Course;
import ru.kpfu.itis.nikolaev.net.util.DatabaseConnectionUtil;

import javax.servlet.ServletContext;
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
import java.util.List;

@WebServlet(name = "congratulationServlet", urlPatterns = "/congratulation")

public class CongratulationServlet extends HttpServlet {
    Dao courseDaoImpl;

    @Override
    public void init() throws ServletException {
        ServletContext sc = getServletContext();
        courseDaoImpl = (Dao) sc.getAttribute("courseDaoImpl");
    }

    private final Connection connection = DatabaseConnectionUtil.getConnection();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("name", req.getParameter("name"));
        req.setAttribute("area", req.getParameter("area"));
        req.setAttribute("subject",req.getParameter("subject"));
        courseDaoImpl.save(new Course(generateId(),
                req.getParameter("name"),
                4000,
                8,
                req.getParameter("subject"),
                req.getParameter("area")));
        req.getRequestDispatcher("congratulation.ftl").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
    private int generateId() {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT MAX(id) FROM schema.courses";
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