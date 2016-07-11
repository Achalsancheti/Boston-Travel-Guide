package com.achal.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.achal.spring.dao.OfferDAO;
import com.achal.spring.dao.UserDAO;
import com.achal.spring.exception.AdException;
import com.achal.spring.pojo.Offer;
import com.achal.spring.pojo.User;

@Controller
@RequestMapping("/offer.htm")
public class OffersController {

	@Autowired
	@Qualifier("offerValidator")
	
	OfferValidator validator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("offer") Offer offer, BindingResult result) throws Exception {
		

		validator.validate(offer, result);
        
  		if (result.hasErrors()) {
  			return "OfferPage";
  		}
  		try {
  			OfferDAO offerDao = new OfferDAO();
  			
  			offerDao.create(offer.getPlace(), offer.getOffer(), offer.getOfferCode(),offer.getExpiryDate(),offer.getExpiryTime(),offer.getUser());
  		} catch (AdException e) {
  			System.out.println("Exception: " + e.getMessage());
  		}

  		return "AddedOffer";
        
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("offer") Offer offer, BindingResult result) {

		return "OfferPage";
	}
	
}
