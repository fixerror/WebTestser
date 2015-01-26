package ua.radchenko.jee.services;

import java.util.List;

import com.restfb.types.User;

import ua.radchenko.jee.entities.Account;
import ua.radchenko.jee.entities.Role;
import ua.radchenko.jee.exceptions.InvalidUserInputException;
import ua.radchenko.jee.forms.SignUpForm;

/**
 * @author radchenko.as
 * @version 1.0
 */
public interface CommonService {

	Account login(String email, String password, int role)
			throws InvalidUserInputException;

	Account signUp(SignUpForm form) throws InvalidUserInputException;

	Account login(User user) throws InvalidUserInputException;

	List<Role> listAllRoles();
}
