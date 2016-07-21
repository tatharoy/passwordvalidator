package com.davita.passwordvalidator.boot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;

import com.davita.passwordvalidator.validator.CaseValidator;
import com.davita.passwordvalidator.validator.LengthValidator;
import com.davita.passwordvalidator.validator.PasswordValidator;
import com.davita.passwordvalidator.validator.SavedPasswordCheckValidator;
import com.davita.passwordvalidator.validator.SequenceValidator;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class ValidatorConfig {

	@Bean
	public PasswordValidator caseValidator(){
		return new CaseValidator();
	}
	
	@Bean
	public PasswordValidator lengthValidator(){
		return new LengthValidator();
	}
	
	@Bean
	public PasswordValidator sequenceValidator(){
		return new SequenceValidator();
	}
	
	@Bean
	public PasswordValidator savedPasswordCheckValidator(){
		return new SavedPasswordCheckValidator();
	}
	
	@Bean
	public List<PasswordValidator> validators(){
		List<PasswordValidator> validators  =  new ArrayList<PasswordValidator>();
		validators.add(caseValidator());
		validators.add(lengthValidator());
		validators.add(sequenceValidator());
		validators.add(savedPasswordCheckValidator());
		return validators;
	}
}
