package ru.kpfu.itis.nikolaev.net.server;

import ru.kpfu.itis.nikolaev.net.util.DatabaseConnectionUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet(name = "congratulationServlet", urlPatterns = "/congratulation")

public class CongratulationServlet extends HttpServlet {
    private final Connection connection = DatabaseConnectionUtil.getConnection();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("name", req.getParameter("name"));
        req.setAttribute("area", req.getParameter("area"));
        req.setAttribute("subject",req.getParameter("subject"));
        req.getRequestDispatcher("congratulation.ftl").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}