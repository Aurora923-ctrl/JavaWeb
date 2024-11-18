package web;

import beans.LoginStatus;
import beans.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import service.UserService;
import utils.ResultUtils;

import java.io.IOException;

@WebServlet("/user/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User(username, password);

        UserService userService = new UserService();
        User existUser = userService.login(user);
        String responseData;
        if (existUser != null) {
            request.getSession().setAttribute("existUser", existUser);
            String autoLogin = request.getParameter("autoLogin");
            if (autoLogin != null && autoLogin.equals("on")) {
                Cookie cookie = new Cookie("autoLogin", user.getUsername() + "#" + user.getPassword());
                cookie.setMaxAge(7 * 24 * 60 * 60);
                cookie.setPath(request.getContextPath());
                response.addCookie(cookie);
            }
            responseData = ResultUtils.result(LoginStatus.LOGIN_SUCCESS, existUser);
        }else {
            responseData=ResultUtils.result(LoginStatus.LOGIN_FAIL,new User(username,password));
        }


        response.getWriter().write(responseData);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
