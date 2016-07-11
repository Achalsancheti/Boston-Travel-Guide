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
import com.achal.spring.pojo.User;

@Controller
@RequestMapping("/restaurent.htm")
public class ViewRestaurentController {

	AdvertisementDAO advertDAO=null;
	List adList = new ArrayList();   
	
	@RequestMapping(method = RequestMethod.GET)
	ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
        
		try{
			advertDAO = new AdvertisementDAO();
			adList = advertDAO.viewRestaurents();
			
			
		}catch (AdException e) {
            System.out.println(e.getMessage());
        }

        ModelAndView mv = new ModelAndView("Restaurent", "advertisement", adList);
        return mv;
    }
	
	@RequestMapping(method = RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("advert") Advertisement advertisement, HttpServletRequest request, HttpServletResponse response) throws Exception {
		  advertisement.setTitle(request.getParameter("title"));
        
		try{
			String recommendation="Recommended";
  			AdvertisementDAO advertisementDAO = new AdvertisementDAO();
  			advertisementDAO.update(recommendation,advertisement.getTitle());
			
		}catch (AdException e) {
            System.out.println(e.getMessage());
        }

		JSONObject obj = new JSONObject();
        obj.put("successmsg", request.getParameter("title") + " Has Been Recommended Successfully");
        PrintWriter out = response.getWriter();
        out.println(obj);
        return null;
    }
	
}
