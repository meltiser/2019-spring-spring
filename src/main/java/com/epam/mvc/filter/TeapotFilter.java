package com.epam.mvc.filter;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class TeapotFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        String parameter = httpServletRequest.getParameter("teapot");
        if (parameter != null && parameter.equals("true")) {
            httpServletResponse.sendError(418, "Can't forbid you being a teapot ¯\\_(ツ)_/¯");
        }

        chain.doFilter(request, response);
    }
}
