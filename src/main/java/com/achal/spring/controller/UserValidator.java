package com.achal.spring.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

import com.achal.spring.pojo.User;

public class UserValidator implements Validator {
	
	private static final String IMAGE_PATTERN = "([^\\s]+(\\.(?i)(jpg|png|gif|bmp))$)";

	@Override
	public boolean supports(Class aClass) {
		return aClass.equals(User.class);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Pattern pattern = Pattern.compile(IMAGE_PATTERN);
        Matcher matcher;
        MultipartFile photo;
		
		User user = (User) obj;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "error.invalid.user", "First Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "error.invalid.user", "Last Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "error.invalid.user", "User Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.password", "Password Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "roleType", "error.invalid.roleType", "RoleType Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email.emailId", "error.invalid.email.emailId", "Email Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "number.phoneNumber", "error.invalid.number.phoneNumber", "PhoneNumber Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gender", "error.invalid.gender", "Gender Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "zipCode", "error.invalid.zipCode", "ZipCode Required");
        ValidationUtils.rejectIfEmpty(errors, "photo","error.invalid.photo", "Field cannot be empty");
        
        photo = user.getPhoto();
        matcher = pattern.matcher(photo.getOriginalFilename());
        
        if(0 == photo.getSize()) {
           errors.rejectValue("photo","Test","File is empty");
        }
              if(!matcher.matches()) {
             errors.rejectValue("photo","Test","Invalid Image Format");
        }
        
        if(5000000 < photo.getSize()) {
             errors.rejectValue("photo","Test","File size is over 5mb !");
        }
	}

}
