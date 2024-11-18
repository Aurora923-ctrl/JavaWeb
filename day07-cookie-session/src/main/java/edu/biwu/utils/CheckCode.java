package edu.biwu.utils;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/checkCode")
public class CheckCode extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String input = request.getParameter("randomCode");
        Object code = request.getSession().getAttribute("code");
        if (input.equalsIgnoreCase(code.toString())) {
            response.getWriter().write("true");
        }else {
            response.getWriter().write("false");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
