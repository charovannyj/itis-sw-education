package ru.kpfu.itis.nikolaev.net.server;

import ru.kpfu.itis.nikolaev.net.dao.impl.ForumDaoImpl;
import ru.kpfu.itis.nikolaev.net.dao.impl.RatingDaoImpl;
import ru.kpfu.itis.nikolaev.net.model.Forum;
import ru.kpfu.itis.nikolaev.net.model.Rating;
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
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@WebServlet(name = "ratingServlet", urlPatterns = "/rating")

public class RatingServlet extends HttpServlet {
    private final Connection connection = DatabaseConnectionUtil.getConnection();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        List<Rating> ratings = new RatingDaoImpl().getAll(); // Получаем данные из базы данных
        StringBuilder sb = new StringBuilder();
        for(Rating rating : ratings){
            sb.append(rating.toString()).append("<br><br>");
        }
        req.setAttribute("ratings", sb);
        req.getRequestDispatcher("rating.ftl").forward(req,resp);*/
        /*int personId = Integer.parseInt(req.getParameter("personId"));
        List<String> subjects = getSubjectsForPerson(personId);
        String optionsHtml = "";
        for (String subject : subjects) {
            optionsHtml += "<option value='" + getId(subject) + "'>" + subject + "</option>";
        }
        resp.setContentType("text/html");
        resp.getWriter().write(optionsHtml);*/
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        req.setAttribute("names", getNamesTeacher());
        req.setAttribute("areas", getAreas());
        req.setAttribute("subjects", getSubjects());
        req.setAttribute("ratings", new RatingDaoImpl().getAll());
        req.getRequestDispatcher("rating.ftl").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        int id = generateId();
        String login = req.getSession().getAttribute("login").toString();
        String content = req.getParameter("message");
        String name = req.getParameter("name");
        String area = req.getParameter("area");
        String grade = req.getParameter("grade");
        String subject = req.getParameter("subject");
        Rating rating = Rating.builder()
                .id(id)
                .subject(subject)
                .teacher(name)
                .content(content)
                .grade(grade)
                .login_user(login)
                .area(area)
                .build();
        new RatingDaoImpl().save(rating);
        doGet(req,resp);
    }
    private Set<String> getNamesTeacher(){
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM schema.teachers";
            ResultSet resultSet = statement.executeQuery(sql);
            List<String> names = new ArrayList<>();
            if (resultSet != null) {
                while (resultSet.next()) {
                    names.add(resultSet.getString("name")
                    );
                }
            }
            return new HashSet<>(names);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private Set<String> getAreas(){
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM schema.teachers";
            ResultSet resultSet = statement.executeQuery(sql);
            List<String> names = new ArrayList<>();
            if (resultSet != null) {
                while (resultSet.next()) {
                    names.add(resultSet.getString("area")
                    );
                }
            }
            return new HashSet<>(names);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Set<String> getSubjects(){
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM schema.teachers";
            ResultSet resultSet = statement.executeQuery(sql);
            List<String> names = new ArrayList<>();
            if (resultSet != null) {
                while (resultSet.next()) {
                    names.add(resultSet.getString("subject")
                    );
                }
            }
            return new HashSet<>(names);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private int generateId() {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT MAX(id) FROM schema.ratings";
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