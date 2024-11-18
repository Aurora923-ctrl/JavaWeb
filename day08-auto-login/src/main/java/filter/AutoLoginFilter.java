package filter;

import beans.User;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.UserService;
import utils.CookieUtils;

import java.io.IOException;
@WebFilter("/*")
public class AutoLoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req=(HttpServletRequest) servletRequest;
        HttpServletResponse resp=(HttpServletResponse) servletResponse;
        User existUser = (User) req.getSession().getAttribute("existUser");
        if (existUser != null) {
            filterChain.doFilter(req,resp);
        }else {
            Cookie cookie = CookieUtils.getCookie("autoLogin", req.getCookies());
            if (cookie == null) {
                filterChain.doFilter(req,resp);
            }else {
                String[] values = cookie.getValue().split("#");
                UserService userService = new UserService();
                User login = userService.login(new User(values[0], values[1]));
                if (login == null) {
                    filterChain.doFilter(req,resp);
                }else {
                    req.getSession().setAttribute("existUser", login);
                    filterChain.doFilter(req,resp);
                }
            }
        }
    }
}
