package com.epam.mvc.filter;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse ) response;
        httpServletResponse.addCookie(new Cookie("filter", "kyka"));

        chain.doFilter(request, response);
    }
}
