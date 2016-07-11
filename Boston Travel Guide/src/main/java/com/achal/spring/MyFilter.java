package com.achal.spring;
 
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class MyFilter implements Filter {
 
    @Override
    public void init(FilterConfig fc) throws ServletException {
       }
 
    @Override
    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {
        fc.doFilter(new XSSRequestWrapper((HttpServletRequest)sr),sr1);
    }
 
    @Override
    public void destroy() {
       }
    
}