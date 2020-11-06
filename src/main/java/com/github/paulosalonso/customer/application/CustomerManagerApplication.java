package com.github.paulosalonso.customer.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.github.paulosalonso.customer")
@EntityScan(basePackages = "com.github.paulosalonso.customer")
@EnableJpaRepositories(basePackages = "com.github.paulosalonso.customer")
public class CustomerManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerManagerApplication.class, args);
	}

}
