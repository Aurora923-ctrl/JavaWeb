package edu.biwu;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@WebServlet("/context01")
public class ServletContextDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        System.out.println(servletContext);
        String realPath = servletContext.getRealPath("/WEB-INF/classes/db.properties");
        System.out.println(realPath);
        Properties properties = new Properties();
        properties.load(new FileInputStream(realPath));
        System.out.println(properties);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
