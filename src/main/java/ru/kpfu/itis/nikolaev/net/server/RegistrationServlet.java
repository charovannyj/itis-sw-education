package ru.kpfu.itis.nikolaev.net.server;

import ru.kpfu.itis.nikolaev.net.dao.impl.UserDaoImpl;
import ru.kpfu.itis.nikolaev.net.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "registrationServlet", urlPatterns = "/registration")

public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("registration.ftl");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String date = req.getParameter("date");
        String password = req.getParameter("password");
        String gender = req.getParameter("gender");
        String position = req.getParameter("position");
        User newUser = User.builder()
                .id(1)
                .name(name)
                .login(login)
                .date(date)
                .password(password)
                .gender(gender)
                .position(position)
                .build();
        new UserDaoImpl().save(newUser);
        resp.sendRedirect("login");
    }
}
