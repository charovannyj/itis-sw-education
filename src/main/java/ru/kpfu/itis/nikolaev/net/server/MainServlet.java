package ru.kpfu.itis.nikolaev.net.server;

import ru.kpfu.itis.nikolaev.net.dao.impl.ForumDaoImpl;
import ru.kpfu.itis.nikolaev.net.model.Forum;
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
import java.util.List;

@WebServlet(name = "mainServlet", urlPatterns = "/main")

public class MainServlet extends HttpServlet {
    private final Connection connection = DatabaseConnectionUtil.getConnection();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Forum> forums = new ForumDaoImpl().getAll(); // Получаем данные из базы данных
        StringBuilder sb = new StringBuilder();
        for(Forum forumik : forums){
            sb.append(forumik.toString()).append("<br><br>");
        }
        req.setAttribute("forums", sb); // Передаем данные в шаблон

        req.getRequestDispatcher("main.ftl").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //String[] messages = request.getParameterValues("message");

        int id = generateId();
        String login = req.getSession().getAttribute("login").toString();
        String time = LocalDate.now() + " " + String.valueOf(LocalTime.now()).substring(0,8);
        String content = req.getParameter("message");
        Forum forum = Forum.builder()
                .id(id)
                .login_user(login)
                .time(time)
                .content(content)
                .build();
        new ForumDaoImpl().save(forum);
        doGet(req,resp);
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