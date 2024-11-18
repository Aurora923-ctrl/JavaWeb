package edu.biwu.cookie02;

import edu.biwu.utils.CookieUtils;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/path01/getCookie01")
public class GetCookie01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        Cookie cookie = CookieUtils.getCookie(cookies, "gender");
        response.getWriter().write(cookie==null ? "null": cookie.getValue());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
