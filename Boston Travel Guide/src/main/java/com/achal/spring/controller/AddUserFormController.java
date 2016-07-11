package com.achal.spring.controller;

import java.io.File;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.achal.spring.controller.UserValidator;
import com.achal.spring.dao.UserDAO;
import com.achal.spring.exception.AdException;
import com.achal.spring.pojo.User;

@SuppressWarnings("deprecation")
@Controller
@RequestMapping("/adduser.htm")
public class AddUserFormController extends SimpleFormController {

	@Autowired
	@Qualifier("userValidator")
	
	UserValidator validator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("user") User user, BindingResult result) throws Exception {
		
	       File file;
	       String check = File.separator; //Checking if system is linux based or windows based by checking seprator used.
	       String path = null;
	       if(check.equalsIgnoreCase("\\")) {
	    	   path = getServletContext().getRealPath("").replace("build\\",""); //Netbeans projects gives real path as Lab6/build/web/ so we need to replace build in the path.
	    }
	    
	        if(check.equalsIgnoreCase("/")) {
	        	path = getServletContext().getRealPath("").replace("build/","");
	       path += "/"; //Adding trailing slash for Mac systems.

	    }
	       
	        if(user.getPhoto() != null){
	          String fileNameWithExt=System.currentTimeMillis()+user.getPhoto().getOriginalFilename();
	          file=new File(path+fileNameWithExt);
	          String context = getServletContext().getContextPath();
	          
	          user.getPhoto().transferTo(file);
	          user.setPhotoName(context + "/" + fileNameWithExt);

	          validator.validate(user, result);
	          
	  		if (result.hasErrors()) {
	  			return "addUserForm";
	  		}
	  		try {
	  			UserDAO userDao = new UserDAO();
	  			
	  			userDao.create(user.getUserName(), user.getPassword(), user.getRoleType(), user.getEmail().getEmailId(), user.getFirstName(), user.getLastName(), user.getNumber().getPhoneNumber(), user.getZipCode(), user.getGender(),user.getPhotoName());
	  		} catch (AdException e) {
	  			System.out.println("Exception: " + e.getMessage());
	  		}

	  		return "AddedUser";
	        }
	        return "addUserForm";
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("user") User user, BindingResult result) {

		return "addUserForm";
	}
}
