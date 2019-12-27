package com.zemoga.challenge.controller;

import com.zemoga.challenge.app.JpaConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages = "com.zemoga.challenge")
@EnableJpaRepositories("com.zemoga.challenge")
public class ChallengeApplication {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JpaConfig.class);
		SpringApplication.run(ChallengeApplication.class, args);
	}

}
