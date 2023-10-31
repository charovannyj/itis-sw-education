package ru.kpfu.itis.nikolaev.net.server;

import ru.kpfu.itis.nikolaev.net.dao.impl.UserDaoImpl;
import ru.kpfu.itis.nikolaev.net.model.User;
import ru.kpfu.itis.nikolaev.net.util.DatabaseConnectionUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import static java.lang.System.out;

@WebServlet(name = "registrationServlet", urlPatterns = "/registration")

public class RegistrationServlet extends HttpServlet {
    private final Connection connection = DatabaseConnectionUtil.getConnection();

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
        if (validateName(name)&&validateLogin(login)&&validateDate(date)&&validatePassword(password)){
            req.setAttribute("registrationError","Correct data");
            try {
                if (!loginIsExist(login)) {
                    User newUser = User.builder()
                            .id(generateId())
                            .name(name)
                            .login(login)
                            .date(date)
                            .password(password)
                            .gender(gender)
                            .position(position)
                            .build();
                    new UserDaoImpl().save(newUser);
                    resp.sendRedirect("login");
                } else {
                    doGet(req, resp);
                    //добавить сообщение, что логин уже существует
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        else{
            req.setAttribute("registrationError","Incorrect data");
            resp.getWriter().println("Incorrect data");
        }
    }

    private boolean loginIsExist(String login) throws SQLException {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM schema.users WHERE login='" + login + "'";
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private int generateId(){
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT MAX(id) FROM schema.users";
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return resultSet.getInt(1)+1;
            } else {
                return 0;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private boolean validateName(String name) {
        String regex = "^[a-zA-Z]+([ -]?[a-zA-Z])*$";
        return name.matches(regex);
    }
    private boolean validateLogin(String login){
        String regex = "^[a-zA-Z0-9]+$";
        return login.matches(regex);
    }
    private boolean validatePassword(String password){
        String regex = "^.{8,}$";
        return password.matches(regex);
    }
    private boolean validateDate(String date){
        String regex = "^\\d{4}-\\d{2}-\\d{2}$";
        return date.matches(regex);
    }
}
