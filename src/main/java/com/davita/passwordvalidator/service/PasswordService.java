package com.davita.passwordvalidator.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.davita.passwordvalidator.entity.Password;
import com.davita.passwordvalidator.repository.PasswordRepository;
/**
 * 
 * Service class to save the password. At this moment it is being saved in an in-memory H2 database. Can be configured to be used to
 * be saved in physical DB 
 * @author taroy
 *
 */
@Service
public class PasswordService {
	
	@Autowired
	private PasswordRepository passwordRepository;
	
	/**
	 * Save method
	 * @param password 
	 */
	public void save(String password){
		Password passwordEntity  = new Password();
		passwordEntity.setPassword(password);
		passwordEntity.setSavedDate(new Date());
		passwordRepository.save(passwordEntity);
		
		
		
	}

}
