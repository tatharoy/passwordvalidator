
package com.davita.passwordvalidator.boot;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * MVC Configuration file ..
 */
@EnableWebMvc
@Configuration("mvcConfig")
public class MVCConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		super.configureMessageConverters(converters);
		converters.add(converter());
	}

	/**
	 * converter method of the {@link MVCConfig} resource .
	 * 
	 * @return converter .
	 */
	@Bean
	MappingJackson2HttpMessageConverter converter() {
		final MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		return converter;
	}

	@Bean
	ModelMessageConverterViewResolver viewResolver() {
		final ModelMessageConverterViewResolver viewResolver = new ModelMessageConverterViewResolver(converter());
		return viewResolver;
	}

}
