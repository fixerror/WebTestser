package ua.radchenko.jee.components.impl;



import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.radchenko.jee.ApplicationConstants;
import ua.radchenko.jee.forms.LoginForm;



/**
 * @author radchenko.as
 * @version 1.0
 */
@Component("loginFormValidator")
public class LoginFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return LoginForm.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "login.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.required");
		
		LoginForm form = (LoginForm) target;
		if(!ApplicationConstants.ROLES.contains(form.getIdRole())) {
			errors.rejectValue("idRole", "role.required");
		}
	}

}
