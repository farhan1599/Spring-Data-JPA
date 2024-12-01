package com.springboot.jpa;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.springboot.jpa.service.UserService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

		// getting UserService bean object
		UserService userService = context.getBean(UserService.class);

		userService.saveUser(); //*UPSERT = Update + Insert*

		// userService.saveUsers();

		//userService.findAllUsers();

		// userService.getUserById(101);

		// userService.deleteUser(101);

		// userService.deleteAllUsers();
	}

}
