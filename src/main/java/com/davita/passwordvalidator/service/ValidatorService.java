package com.davita.passwordvalidator.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.davita.passwordvalidator.exception.InvalidPasswordException;
import com.davita.passwordvalidator.util.ValidationResult;
import com.davita.passwordvalidator.validator.PasswordValidator;


/**
 * 
 * @author taroy
 * 
 * This is a validator service which has injected validators which are called in sequence to validate the password. Anyone who wants to 
 * validate a password should call this service 
 *
 */
@Service
public class ValidatorService {

	@Autowired
	private List<PasswordValidator> validators;
	
	/** The logger. */
    private final Logger log = LoggerFactory.getLogger(ValidatorService.class);
	
    /**
     * validate a password
     * @param password
     * @return ValidationResult
     */
	public ValidationResult validate(String password){
		ValidationResult result =  new ValidationResult();
		result.setValid(true);
		for(PasswordValidator validator : validators){
			try {
				log.debug("validating against {} for password {}",validator.getClass().getName(),password);
				validator.validate(password);
			} catch (InvalidPasswordException e) {
				log.warn("validating failed against {} for password {}",validator.getClass().getName(),password);
				result.setValid(false);
				result.addValidationError(e.getMessage());
			}
		}
		return result;
		
	}
}
