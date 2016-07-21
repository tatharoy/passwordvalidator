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
 * This is a validator which will test whether there is no repeated sequence of characters
 */

@Component
public class SequenceValidator implements PasswordValidator {
	
	

	@Override
	public void validate(String password) throws InvalidPasswordException {
		String regex = "(?!(.+?)\\1).*";

		Pattern pattern1 = Pattern.compile(regex);
		Matcher matcher1 = pattern1.matcher(password);
		if (!matcher1.matches()) {
			throw new InvalidPasswordException("Password must not contain any sequence of characters immediately followed by the same sequence.");
		}

	}
	
}
