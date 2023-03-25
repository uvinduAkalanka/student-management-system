package com.management.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.management.system")
public class SystemApplication {
	public static void main(String[] args) {
		SpringApplication.run(SystemApplication.class, args);
	}

}