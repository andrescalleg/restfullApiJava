package com.zemoga.challenge.controller;

import com.zemoga.challenge.app.JpaConfig;
import com.zemoga.challenge.repository.PortfolioRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {"com.zemoga.challenge"})
public class ChallengeApplication {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JpaConfig.class);
		context.getBean(PortfolioRepository.class);

		SpringApplication.run(ChallengeApplication.class, args);
	}

}
