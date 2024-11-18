package edu.biwu.filter2;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebInitParam;

import java.io.IOException;

//@WebFilter(filterName = "charsetFilter",urlPatterns="/*",initParams=@WebInitParam(name = "charset",value = "UTF-8"))
public class CharsetFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println(this+"开始执行");
        FilterRegistration charsetFilter = request.getServletContext().getFilterRegistration("charsetFilter");
        String charset = charsetFilter.getInitParameter("charset");
        response.setContentType("text/html;charset="+charset);
        chain.doFilter(request, response);
        System.out.println(this+"结束执行");
    }


}
