package com.billies_works.demo.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
public class FilterEmp implements Filter {
    public void init( FilterConfig fConfig ) throws ServletException {}

    public void doFilter( ServletRequest request,
                          ServletResponse response,
                          FilterChain chain)
        throws IOException, ServletException {

        request.setCharacterEncoding("UTF-8");
        chain.doFilter( request, response );
    }

    public void destroy() {}
}

// 修正時刻: Mon Feb 15 17:56:16 2021
