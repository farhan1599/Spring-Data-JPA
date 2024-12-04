package com.springboot.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.springboot.jpa.service.UserService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		UserService userService = context.getBean(UserService.class);

		userService.saveOneUser(107, "Bob", "Male", "Japan");
		// userService.getUsers();
		// userService.UpdateCountry("USA", 101);
		// userService.deleteUserById(106);
		
	}

}
