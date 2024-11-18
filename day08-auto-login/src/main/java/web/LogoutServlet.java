package web;

import beans.LoginStatus;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import utils.CookieUtils;
import utils.ResultUtils;

import java.io.IOException;

@WebServlet("/user/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().invalidate();
        Cookie cookie = CookieUtils.getCookie("autologin", request.getCookies());
        if (cookie != null) {
            cookie.setMaxAge(0);
            cookie.setValue(cookie.getPath());
            response.addCookie(cookie);
        }
        String responseData = ResultUtils.result(LoginStatus.LOGIN_OUT, null);
        response.getWriter().write(responseData);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
