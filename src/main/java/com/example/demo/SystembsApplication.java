package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.example.security", "com.example.entity", "com.example.service"})
@EntityScan("com.example.entity")
@EnableJpaRepositories({"com.example.repository"})
public class SystembsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SystembsApplication.class, args);
	}

}
