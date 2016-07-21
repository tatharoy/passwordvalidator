package com.davita.passwordvalidator.validator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

import com.davita.passwordvalidator.exception.InvalidPasswordException;
import com.davita.passwordvalidator.repository.PasswordRepository;


/**
 * 
 * @author taroy
 * 
 * This is a validator which will test whether the password has already been saved and is one of the last three saved entries
 *
 */
@Component
public class SavedPasswordCheckValidator implements PasswordValidator {

	@Autowired
	private PasswordRepository passwordRepository;

	@Override
	public void validate(String password) throws InvalidPasswordException {
		Pageable lastThree = new PageRequest(0, 3, Direction.DESC,"sequence");
		List<String> passwords = passwordRepository.findPasswords(lastThree);
		if (passwords.contains(password)) {
			throw new InvalidPasswordException(
					"The password should not be the same as any of the users three most recent passwords.");
		}

	}

}
