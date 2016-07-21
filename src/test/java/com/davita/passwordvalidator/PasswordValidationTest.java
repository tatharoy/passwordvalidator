package com.davita.passwordvalidator;


import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.davita.passwordvalidator.boot.RepositoryConfiguration;
import com.davita.passwordvalidator.boot.ValidatorConfig;
import com.davita.passwordvalidator.entity.Password;
import com.davita.passwordvalidator.repository.PasswordRepository;
import com.davita.passwordvalidator.service.ValidatorService;
import com.davita.passwordvalidator.util.ValidationResult;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {RepositoryConfiguration.class,ValidatorConfig.class,ValidatorService.class})
@WebAppConfiguration
public class PasswordValidationTest {


    private PasswordRepository passwordRepository;
    
    private ValidatorService validatorService;

    
    @Autowired
    public void setPasswordRepository(PasswordRepository passwordRepository) {
		this.passwordRepository = passwordRepository;
	}
    
    
    @Autowired
    public void setValidatorService(ValidatorService validatorService) {
		this.validatorService = validatorService;
	}



	@Before
    public void setUp(){
    	String password = "test123";
        Password passwordEntity  = new Password();
		passwordEntity.setPassword(password);
		passwordEntity.setSavedDate(new Date());
		Password savedPassword = passwordRepository.save(passwordEntity);
		passwordEntity  = new Password();
		passwordEntity.setPassword("abc321");
		passwordEntity.setSavedDate(new Date());
		savedPassword = passwordRepository.save(passwordEntity);
		passwordEntity  = new Password();
		passwordEntity.setPassword("cde321");
		passwordEntity.setSavedDate(new Date());
		savedPassword = passwordRepository.save(passwordEntity);
		passwordEntity  = new Password();
		passwordEntity.setPassword("qqe321");
		passwordEntity.setSavedDate(new Date());
		savedPassword = passwordRepository.save(passwordEntity);
 	}

	
	@Test
    public void testInvalidCasePassword() throws Exception {
		String password = "Tatha321";
		ValidationResult result =  validatorService.validate(password);
		Assert.assertFalse(result.isValid());
		password = "Tatha";
		result =  validatorService.validate(password);
		Assert.assertFalse(result.isValid());
    }
	
	@Test
    public void testInvalidLengthPassword() throws Exception {
		String password = "Tath";
		ValidationResult result =  validatorService.validate(password);
		Assert.assertFalse(result.isValid());
		password = "Tatha123456098765";
		result =  validatorService.validate(password);
		Assert.assertFalse(result.isValid());
    }

	@Test
    public void testInvalidSequencePassword() throws Exception {
		String password = "TathTath";
		ValidationResult result =  validatorService.validate(password);
		Assert.assertFalse(result.isValid());
	}
	
	@Test
    public void testInvalidSavedPassword() throws Exception {
		String password = "cde321";
		ValidationResult result =  validatorService.validate(password);
		Assert.assertFalse(result.isValid());
	}
	
	@Test
    public void testValidPassword() throws Exception {
		String password = "tatha321";
		ValidationResult result =  validatorService.validate(password);
		Assert.assertTrue(result.isValid());
    }

    
}
