package com.achal.spring.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

import com.achal.spring.pojo.Advertisement;
import com.achal.spring.pojo.User;

@Component
public class AdvertisementValidator implements Validator {

	private static final String IMAGE_PATTERN = "([^\\s]+(\\.(?i)(jpg|png|gif|bmp))$)";
	

	public boolean supports(Class aClass) {
		return aClass.equals(Advertisement.class);
	}

	public void validate(Object obj, Errors errors) {
		Pattern pattern = Pattern.compile(IMAGE_PATTERN);
        Matcher matcher;
        MultipartFile photo;
		
		Advertisement newAdvert = (Advertisement) obj;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "error.invalid.title", "Title Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "message", "error.invalid.message", "Message Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "location", "error.invalid.location", "Location Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "postedBy", "error.invalid.postedBy", "Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phoneNumber", "error.invalid.phoneNumber", "PhoneNumber Required");
        ValidationUtils.rejectIfEmpty(errors, "photo","error.invalid.photo", "Field cannot be empty");
        
        photo = newAdvert.getPhoto();
        matcher = pattern.matcher(photo.getOriginalFilename());
        
        if(0 == photo.getSize()) {
           errors.rejectValue("photo","error.invalid.photo","File is empty");
        }
              if(!matcher.matches()) {
             errors.rejectValue("photo","error.invalid.photo","Invalid Image Format");
        }
        
        if(5000000 < photo.getSize()) {
             errors.rejectValue("photo","error.invalid.photo","File size is over 5mb !");
        }
		
	}

}
