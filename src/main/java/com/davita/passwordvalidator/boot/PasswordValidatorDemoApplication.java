package com.davita.passwordvalidator.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.davita.passwordvalidator.*" })
public class PasswordValidatorDemoApplication extends SpringBootServletInitializer  {

	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(PasswordValidatorDemoApplication.class);
	}
	
	public static void main(String[] args) {

		SpringApplication.run(PasswordValidatorDemoApplication.class, args);
	}
}
