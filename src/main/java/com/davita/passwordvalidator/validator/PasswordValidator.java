package com.davita.passwordvalidator.validator;

import com.davita.passwordvalidator.exception.InvalidPasswordException;

public interface PasswordValidator {
	
	public void validate(String password) throws InvalidPasswordException;

}
