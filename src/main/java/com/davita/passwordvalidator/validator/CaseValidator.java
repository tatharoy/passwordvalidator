package com.davita.passwordvalidator.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.davita.passwordvalidator.exception.InvalidPasswordException;

/**
 * 
 * @author taroy
 * 
 * This is a validator which will test whether the password is only a mixture of lower cases and numeric digits only
 *
 */


@Component
public class CaseValidator implements PasswordValidator {

	@Override
	public void validate(String password) throws InvalidPasswordException {
		String regex = "^(?=.*\\d)(?=.*[a-z])[a-z0-9]*$";

		Pattern pattern1 = Pattern.compile(regex);
		Matcher matcher1 = pattern1.matcher(password);
		if (!matcher1.matches()) {
			throw new InvalidPasswordException("Password Must consist of a mixture of lowercase letters"
					+ " and numerical digits only, with at least one of each.");
		}

	}
	
	

}
