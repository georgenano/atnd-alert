package com.appspot.atndalert.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

public class LoginCheckFilter implements Filter {
    public void init(FilterConfig conf) throws ServletException {
    }

    public void doFilter(ServletRequest req, ServletResponse resp,
            FilterChain chain) throws IOException, ServletException {
        UserService service = UserServiceFactory.getUserService();
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession();
        if (service.isUserLoggedIn()) {
            session.setAttribute("user", service.getCurrentUser());
        } else {
            session.removeAttribute("user");
            String url = request.getRequestURI();
            String loginurl = service.createLoginURL(url);
            response.sendRedirect(loginurl);
        }
        chain.doFilter(request, response);
    }

    public void destroy() {
    }

}
