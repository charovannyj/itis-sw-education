package ru.kpfu.itis.nikolaev.net.server;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "loginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    public static final String LOGIN = "login";
    public static final String PASSWORD = "password123";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("login.ftl");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if (login.equals(LOGIN)&&password.equals(PASSWORD)){
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("username", login);
            httpSession.setMaxInactiveInterval(60 * 60);

            Cookie cookie = new Cookie("username", login);
            cookie.setMaxAge(24 * 60 * 60);
            resp.addCookie(cookie);

            resp.sendRedirect("/city");
        }
        else{
            doGet(req, resp);
        }
    }
}