package edu.biwu.filter;

import jakarta.servlet.*;

import java.io.IOException;

public class FilterDemo02 implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("FilterDemo02被执行"+request+"...."+response);
        chain.doFilter(request, response);
        System.out.println("FilterDemo02结束执行");

        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write("FilterDemo02的响应");
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
