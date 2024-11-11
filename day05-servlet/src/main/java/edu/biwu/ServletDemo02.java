package edu.biwu;

import jakarta.servlet.*;

import java.io.IOException;

public class ServletDemo02 implements Servlet {
    public ServletDemo02() {
        System.out.println("ServletDemo02的构造方法被调用..." + this);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("ServletDemo02被初始化..." + this);
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("Service方法被调用..." + this);
    }

    @Override
    public String getServletInfo() {
        return "";
    }

    @Override
    public void destroy() {
        System.out.println("destroy方法被调用..." + this);
    }
}
