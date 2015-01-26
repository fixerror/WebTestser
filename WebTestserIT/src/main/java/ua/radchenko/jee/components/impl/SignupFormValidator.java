package ua.radchenko.jee.components.impl;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.radchenko.jee.ApplicationConstants;
import ua.radchenko.jee.forms.LoginForm;
import ua.radchenko.jee.forms.SignUpForm;

/**
 * @author radchenko.as
 * @version 1.0
 */

@Component("signupFormValidator")
public class SignupFormValidator implements Validator {
	@Override
	public boolean supports(Class<?> clazz) {
		return SignUpForm.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login",
				"login.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
				"password.required");

		LoginForm form = (LoginForm) target;
		if (!ApplicationConstants.ROLES.contains(form.getIdRole())) {
			errors.rejectValue("idRole", "role.required");
		}
	}
}