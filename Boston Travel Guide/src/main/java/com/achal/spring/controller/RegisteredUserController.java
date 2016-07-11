package com.achal.spring.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.achal.spring.dao.AdvertisementDAO;
import com.achal.spring.dao.CategoryDAO;
import com.achal.spring.dao.OfferDAO;
import com.achal.spring.dao.UserDAO;
import com.achal.spring.exception.AdException;
import com.achal.spring.pojo.Advertisement;
import com.achal.spring.pojo.Category;
import com.achal.spring.pojo.Email;
import com.achal.spring.pojo.Person;
import com.achal.spring.pojo.PhoneNumber;
import com.achal.spring.pojo.User;

@Controller
@RequestMapping("/registered.htm")
public class RegisteredUserController {
	
	@RequestMapping(method = RequestMethod.GET)
	ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		UserDAO user = null;
        List userList = null; 
        
		try{
			user = new UserDAO();
			userList = user.getit();
			
		}catch (AdException e) {
            System.out.println(e.getMessage());
        }

        ModelAndView mv = new ModelAndView("RegisteredUser", "userList", userList);
        return mv;
        
	}
	
	@RequestMapping(method = RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("user") User user, HttpServletRequest request, HttpServletResponse response) throws Exception {

		Long n = Long.parseLong(request.getParameter("personID"));
		
		try{
			UserDAO userDao = new UserDAO();
			userDao.delete(n);
			
		}catch (AdException e) {
            System.out.println(e.getMessage());
        }

		JSONObject obj = new JSONObject();
        obj.put("successmsg", "User with UserID:" + request.getParameter("personID") + " Has Been Deleted Successfully");
        PrintWriter out = response.getWriter();
        out.println(obj);
        return null;
    }

}
