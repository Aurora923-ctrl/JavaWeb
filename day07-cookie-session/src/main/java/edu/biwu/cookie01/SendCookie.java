package edu.biwu.cookie01;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/cookie/send")
public class SendCookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie id = new Cookie("id", "123");
        response.addCookie(id);
        response.addCookie(new Cookie("name","zhangsan"));
        response.addCookie(new Cookie("id","123456"));

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
