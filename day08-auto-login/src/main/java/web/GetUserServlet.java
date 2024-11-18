package web;

import beans.LoginStatus;
import beans.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import utils.ResultUtils;

import java.io.IOException;

@WebServlet("/user/getUser")
public class GetUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User existUser = (User)request.getSession().getAttribute("existUser");
        String responseData=null;
        if(existUser != null) {
            responseData=ResultUtils.result(LoginStatus.LOGIN_SUCCESS,existUser);
        }else {
            responseData=ResultUtils.result(LoginStatus.LOGIN_FAIL,null);
        }
        response.getWriter().write(responseData);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
