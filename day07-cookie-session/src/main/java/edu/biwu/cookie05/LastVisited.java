package edu.biwu.cookie05;

import edu.biwu.utils.CookieUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet("/lastVisited")
public class LastVisited extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        Cookie[] cookies = request.getCookies();
        Cookie cookie = CookieUtils.getCookie(cookies, "lastVisited");
        if (cookie == null) {

            response.getWriter().write("欢迎第一次访问");
        }else {
            String dateStr = cookie.getValue();
            String decodeDate= URLDecoder.decode(dateStr, "utf-8");
            response.getWriter().write("您上次访问时间为"+decodeDate);
        }
        String formatDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());
        String encodeDate = URLEncoder.encode(formatDate, "UTF-8");
        Cookie lastVisited = new Cookie("lastVisited", encodeDate);
        lastVisited.setMaxAge(7*24*60*60);
        lastVisited.setPath(request.getContextPath());
        response.addCookie(lastVisited);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
