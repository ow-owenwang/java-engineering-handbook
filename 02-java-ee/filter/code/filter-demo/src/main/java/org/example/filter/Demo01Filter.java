package org.example.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * 访问所有的资源之前都会执行此过滤器
 */
//@WebFilter(filterName = "Demo01Filter", urlPatterns = "/*")
public class Demo01Filter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        System.out.println("Demo01Filter 1");

        //放行
        chain.doFilter(request, response);

        System.out.println("Demo01Filter 2");
    }
}
