package ru.kpfu.itis.nikolaev.net.server;

import ru.kpfu.itis.nikolaev.net.dao.impl.*;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class InitListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //ServletContextListener.super.contextInitialized(sce);
        sce.getServletContext().setAttribute("courseDaoImpl", new CourseDaoImpl());
        sce.getServletContext().setAttribute("forumDaoImpl", new ForumDaoImpl());
        sce.getServletContext().setAttribute("positionDaoImpl", new PositionDaoImpl());
        sce.getServletContext().setAttribute("ratingDaoImpl", new RatingDaoImpl());
        sce.getServletContext().setAttribute("teacherDaoImpl", new TeacherDaoImpl());
        sce.getServletContext().setAttribute("userDaoImpl", new UserDaoImpl());
    }
}
