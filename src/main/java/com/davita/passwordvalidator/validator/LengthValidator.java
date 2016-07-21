package com.davita.passwordvalidator.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.davita.passwordvalidator.entity.Password;
import com.davita.passwordvalidator.exception.InvalidPasswordException;


/**
 * 
 * @author taroy
 * 
 * This is a validator which will test whether the password length is between 5 to 12 characters
 *
 */
@Component
public class LengthValidator implements PasswordValidator {

	@Override
	public void validate(String password) throws InvalidPasswordException {
		String regex = ".{5,12}";

		Pattern pattern1 = Pattern.compile(regex);
		Matcher matcher1 = pattern1.matcher(password);
		if (!matcher1.matches()) {
			throw new InvalidPasswordException("Password must be between 5 and 12 characters in length.");
		}

	}
	
	


}
