package com.davita.passwordvalidator.repository;

import com.davita.passwordvalidator.entity.Password;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface PasswordRepository extends CrudRepository<Password,Long> {
	
	@Query("SELECT p.password FROM Password p")
	List<String> findPasswords(Pageable pageable);
}
