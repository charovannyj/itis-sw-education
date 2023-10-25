package ru.kpfu.itis.nikolaev.net.server;

import org.json.JSONObject;
import ru.kpfu.itis.nikolaev.net.client.HttpClientImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(name = "cityServlet", urlPatterns = "/city")
public class CityServlet extends HttpServlet {
    Float kelvinCelsius = 273.15F;
    String weather;
    String API = "630038a3144129b2eca8f66b4ec7ec82";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.getRequestDispatcher("city.ftl").forward(req,resp);
        //resp.sendRedirect("city.ftl");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String city = req.getParameter("city");
        weather = new HttpClientImpl().get("https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + API, null);
        HttpSession session = req.getSession();
        setAttributes(session);
        /*PrintWriter pw = resp.getWriter();
        pw.println(session.getAttribute("temperature"));*/
        resp.sendRedirect("weather.ftl");
    }

    private void setAttributes(HttpSession httpSession) {
        JSONObject json = new JSONObject(weather);
        httpSession.setAttribute("temperature", json.getJSONObject("main").getFloat("temp")-kelvinCelsius);
        httpSession.setAttribute("humidity", json.getJSONObject("main").getInt("humidity"));
        httpSession.setAttribute("description", json.getJSONArray("weather").getJSONObject(0).getString("description"));
    }
}