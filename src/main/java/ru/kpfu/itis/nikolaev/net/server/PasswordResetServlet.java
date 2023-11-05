package ru.kpfu.itis.nikolaev.net.server;

import ru.kpfu.itis.nikolaev.net.util.DatabaseConnectionUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "passwordResetServlet", urlPatterns = "/passwordReset")

public class PasswordResetServlet extends HttpServlet {
    private final Connection connection = DatabaseConnectionUtil.getConnection();
    private String answer;
    private String login;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //HttpSession session = req.getSession();
        //session.setAttribute("question", "getQuestion()");
        resp.sendRedirect("password_reset.ftl");
        //req.getRequestDispatcher("start").forward(req,resp);
        // Генерируем HTML-код новых полей ввода
        String newFieldsHtml = "<input type=\"text\" name=\"new-field-3\">\n<input type=\"text\" name=\"new-field-4\">";

        // Отправляем HTML-код в ответ на запрос
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println(newFieldsHtml);
        out.close();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        login = req.getParameter("login");
        //answer = session.getAttribute("answer").toString();
        //добавить проверку логина
        try {
            if (answer.equals(getAnswer())){
                resp.getWriter().println("UI");
                //перекидываем на логин с пустым паролем, и меняем пароль прям в логине
                //resp.sendRedirect("passwordRecovery");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    private String getQuestion() throws SQLException {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM schema.forgot_password WHERE login='" + login + "'";
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return resultSet.getString("question");
            } else {
                throw new RuntimeException("User not found");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private String getAnswer() throws SQLException {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM schema.forgot_password WHERE login='" + login + "'";
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return resultSet.getString("answer");
            } else {
                throw new RuntimeException("User not found");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private int generateId() {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT MAX(id) FROM schema.forgot_password";
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