package com.ci.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ci.model.CIHome;

public class CIHomeValidator implements Validator{

	@Override
	public boolean supports(Class clazz) {
		//just validate the Customer instances
		return CIHome.class.isAssignableFrom(clazz);

	}

	@Override
	public void validate(Object target, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "jobName",
				"required.jobName", "Field name is required.");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "jobDesc",
				"required.jobDesc", "Field name is required.");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "scm",
				"required.scm", "Field name is required.");
			
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "url",
				"required.url", "Field name is required.");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "goal", 
				"required.goal", "Field name is required.");
		
		
	}
	
}