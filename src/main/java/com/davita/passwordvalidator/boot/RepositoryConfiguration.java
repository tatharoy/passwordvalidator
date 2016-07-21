package com.davita.passwordvalidator.boot;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = "com.davita.passwordvalidator.entity")
@EnableJpaRepositories(basePackages = "com.davita.passwordvalidator.repository")
@EnableTransactionManagement
public class RepositoryConfiguration {


}
