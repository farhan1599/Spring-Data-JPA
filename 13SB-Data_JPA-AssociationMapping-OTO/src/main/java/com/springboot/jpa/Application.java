package com.springboot.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.springboot.jpa.entity.Passport;
import com.springboot.jpa.service.PassportService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		PassportService passportService = context.getBean(PassportService.class);
		
		//passportService.saveData();
		//passportService.getPerson();
		//passportService.getPassport();
		//passportService.deletePerson();
		//passportService.deletePassport();
		
	}

}
