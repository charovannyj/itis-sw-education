/*
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
import java.util.HashSet;
import java.util.List;

@WebServlet(name = "searchServlet", urlPatterns = "/search")

public class SearchServlet extends HttpServlet {
    private final Connection connection = DatabaseConnectionUtil.getConnection();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        */
/*List<Forum> forums = new ForumDaoImpl().getAll();
        StringBuilder sb = new StringBuilder();
        for(Forum forumik : forums){
            sb.append(forumik.toString()).append("<br><br>");
        }
        req.setAttribute("forums", sb);*//*

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        req.getRequestDispatcher("forum.ftl").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
    protected String[] searchObjects(String str){
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM schema.teachers";
            ResultSet resultSet = statement.executeQuery(sql);
            List<String> names = new ArrayList<>();
            if (resultSet != null) {
                while (resultSet.next()) {
                    if(resultSet.getString("subject").equals(str)||
                            resultSet.getString("area").equals(str)||
                            resultSet.getString("content").equals(str)||
                            resultSet.getString("name").equals(str)){

                    }

                    names.add(resultSet.getString("subject")
                    );
                }
            }
            return new HashSet<>(names);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}*/
