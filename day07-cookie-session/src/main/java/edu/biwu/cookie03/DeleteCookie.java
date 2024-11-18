package edu.biwu.cookie03;

import edu.biwu.utils.CookieUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/deleteCookie")
public class DeleteCookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = CookieUtils.getCookie(request.getCookies(), "id");
        if (cookie != null) {
            cookie.setMaxAge(0);
            cookie.setPath("/day07-cookie-session");
        }else {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("cookie不存在");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
