package com.achal.spring.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.achal.spring.dao.AdvertisementDAO;
import com.achal.spring.dao.CategoryDAO;
import com.achal.spring.dao.OfferDAO;
import com.achal.spring.exception.AdException;
import com.achal.spring.pojo.Advertisement;
import com.achal.spring.pojo.Category;

@Controller
@RequestMapping("/recommended.htm")
public class RecommendedController {
	
	@RequestMapping(method = RequestMethod.GET)
	ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		AdvertisementDAO advertDAO=null;
		List adList = new ArrayList();   
        
		try{
			advertDAO = new AdvertisementDAO();
			adList = advertDAO.list();
			
		}catch (AdException e) {
            System.out.println(e.getMessage());
        }

        ModelAndView mv = new ModelAndView("RecommendedPlaces", "adList", adList);
        return mv;
    }

}
