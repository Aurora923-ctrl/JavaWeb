package edu.biwu.filter;

import jakarta.servlet.*;

import java.io.IOException;

public class FilterDemo03 implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println(this+"被初始化");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println(this+"开始执行");
        chain.doFilter(request, response);
        System.out.println(this+"结束执行");
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
        System.out.println(this+"被销毁");
    }
}
