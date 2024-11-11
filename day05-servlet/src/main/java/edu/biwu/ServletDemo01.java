package edu.biwu;

import jakarta.servlet.*;

import java.io.IOException;

public class ServletDemo01 implements Servlet {
    @Override
    public void init(ServletConfig config) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("Hello 11");
        res.getWriter().write("<font color='red'>Hello Servlet</font>");
    }

    @Override
    public String getServletInfo() {
        return "";
    }

    @Override
    public void destroy() {

    }
}
