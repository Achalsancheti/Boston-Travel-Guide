package com.achal.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.achal.spring.dao.LoginDAO;
import com.achal.spring.exception.AdException;
import com.achal.spring.pojo.User;

@Controller
@RequestMapping("/login.htm")
public class LoginController {

	@RequestMapping(method = RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("user") User user) throws Exception {

		
			try {
				
				if(user.getUserName().equals("admin@achal") && user.getPassword().equals("admin@achal") && user.getRoleType()==null){
					return "AdminLogin";
				}

				LoginDAO loginDao = new LoginDAO();
				
				user=loginDao.get(user.getUserName(), user.getPassword(),user.getRoleType());
				
				
				
				if(user==null){
					return "Error";
				}else if(user.getUserName()!=null && user.getPassword() != null && user.getRoleType().equals("User")){
					return "loggedInForm";
				}else if(user.getUserName()!=null && user.getPassword() != null && user.getRoleType().equals("Advertiser")){
					return "AdvertiserLogIn";
				}
			} catch (AdException e) {
				System.out.println("Exception: " + e.getMessage());
			}
				return "loggedInForm";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("user") User user) {

		return "loggedInForm";
	}
}
