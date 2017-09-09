package com.achal.spring.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.achal.spring.pojo.Offer;

public class OfferValidator implements Validator {

	@Override
	public boolean supports(Class aClass) {
		return aClass.equals(Offer.class);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Offer user = (Offer) obj;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "place", "error.invalid.place", "Place Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "offer", "error.invalid.offer", "Offer Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "offerCode", "error.invalid.offerCode", "Offer Code Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "expiryDate", "error.invalid.expiryDate", "Expiry Date Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "expiryTime", "error.invalid.expiryTime", "Expiry Time Required");
		
	}
	
	

}
