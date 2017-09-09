package com.achal.spring.controller;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.achal.spring.pojo.Category;

@Component
public class CategoryValidator implements Validator{

	public boolean supports(Class aClass) {
		return aClass.equals(Category.class);
	}


	public void validate(Object obj, Errors errors) {
		Category newCategory = (Category) obj;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "error.invalid.category", "Category Required");
		
	}

}
