package com.achal.spring.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.achal.spring.pojo.User;

@Controller
@RequestMapping("/logout.htm")
public class LogoutController {
	
	@RequestMapping(method = RequestMethod.GET)
	public void initializeForm(@ModelAttribute("user") User user, HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
        session.invalidate();
        try {
			response.sendRedirect("menu.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}

}
