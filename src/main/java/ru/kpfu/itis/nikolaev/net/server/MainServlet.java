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
        /*req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        List<Forum> forums = new ForumDaoImpl().getAll(); // Получаем данные из базы данных
        StringBuilder sb = new StringBuilder();
        for(Forum forumik : forums){
            sb.append(forumik.toString()).append("<br><br>");
        }
        req.setAttribute("forums", sb); // Передаем данные в шаблон*/
        resp.sendRedirect("main.html");
        //req.getRequestDispatcher("main.html").forward(req, resp);
        /*List<Forum> forums = new ForumDaoImpl().getAll();
        req.setAttribute("forums", forums);*/
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //String[] messages = request.getParameterValues("message");


    }


}