package edu.biwu.servlet;

import edu.biwu.bean.User;
import edu.biwu.utils.JDBCUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
//        System.out.println(username + "  " + password);


        User user = null;
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        try {
             user = qr.query("SELECT * FROM user WHERE `username`=? AND `password`=?",
                    new Object[]{username, password}, new BeanHandler<>(User.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (user==null) {
            response.getWriter().write("login fail");
        }else {
            response.getWriter().write("login success");

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
