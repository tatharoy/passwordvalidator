package com.davita.passwordvalidator.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author taroy
 * 
 * Utility class containing the validation result
 *
 */
public class ValidationResult {
	
	private boolean valid;
	
	private List<String> validationErrors;
	
	

	public ValidationResult() {
		super();
		validationErrors = new ArrayList<String>();
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public List<String> getValidationErrors() {
		return validationErrors;
	}

	private void setValidationErrors(List<String> validationErrors) {
		this.validationErrors = validationErrors;
	}
	
	public void addValidationError(String errorMessage){
		this.validationErrors.add(errorMessage);
	}
	
	
	

}
