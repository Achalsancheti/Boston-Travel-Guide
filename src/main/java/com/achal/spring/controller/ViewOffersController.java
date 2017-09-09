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

import com.achal.spring.dao.OfferDAO;
import com.achal.spring.exception.AdException;
import com.achal.spring.pojo.Offer;
import com.achal.spring.pojo.User;

@Controller
@RequestMapping("/offers.htm")
public class ViewOffersController {
	
	@RequestMapping(method = RequestMethod.GET)
	ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		OfferDAO offerDAO=null;
		List offList = new ArrayList();   
        
		try{
			offerDAO = new OfferDAO();
			offList = offerDAO.getAllProducts();
			
		}catch (AdException e) {
            System.out.println(e.getMessage());
        }

        ModelAndView mv = new ModelAndView("ViewOffers", "offerList", offList);
        return mv;
    }
}
