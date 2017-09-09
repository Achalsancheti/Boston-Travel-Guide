package com.achal.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class XSSRequestWrapper extends HttpServletRequestWrapper {
 
    public XSSRequestWrapper(HttpServletRequest servletRequest) {
        super(servletRequest);
    }
 
    @Override
    public String getParameter(String parameter) {
        String value = super.getParameter(parameter);
        return validateXSS(value);
    }
 
    private String validateXSS(String value) {
        if (value != null) {
            value = value.replaceAll("[^\\dA-Za-z0-9]", "").trim();
        }
        return value;
    }
 
}