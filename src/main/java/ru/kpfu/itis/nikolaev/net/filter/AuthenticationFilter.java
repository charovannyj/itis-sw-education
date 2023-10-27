package ru.kpfu.itis.nikolaev.net.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "authenticationFilter", urlPatterns = "/*")
public class AuthenticationFilter implements Filter {
    private static final String LOGIN_URL = "/login";
    private static final String REGISTRATION_URL = "/registration";
    private static final String START_URL = "/start";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        HttpSession session = httpRequest.getSession(false);
        String requestURI = httpRequest.getRequestURI();

        // Check if user is trying to access the profile page
        if (session == null &&
                !requestURI.startsWith(LOGIN_URL) &&
                !requestURI.startsWith(REGISTRATION_URL) &&
                !requestURI.startsWith(START_URL)) {
            httpResponse.sendRedirect(START_URL);
            return;
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}

