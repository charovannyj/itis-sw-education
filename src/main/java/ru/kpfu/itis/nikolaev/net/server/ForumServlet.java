package ru.kpfu.itis.nikolaev.net.server;

import ru.kpfu.itis.nikolaev.net.dao.impl.ForumDaoImpl;
import ru.kpfu.itis.nikolaev.net.model.Forum;
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
import java.util.List;

@WebServlet(name = "forumServlet", urlPatterns = "/forum")

public class ForumServlet extends HttpServlet {
    private final Connection connection = DatabaseConnectionUtil.getConnection();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        List<Forum> forums = new ForumDaoImpl().getAll(); // Получаем данные из базы данных
        StringBuilder sb = new StringBuilder();
        for(Forum forumik : forums){
            sb.append(forumik.toString()).append("<br><br>");
        }
        req.setAttribute("forums", sb);
        req.getRequestDispatcher("forum.ftl").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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