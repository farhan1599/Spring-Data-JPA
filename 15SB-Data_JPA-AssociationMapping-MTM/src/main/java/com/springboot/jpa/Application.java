package com.springboot.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.springboot.jpa.service.UserRoleService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		UserRoleService userRoleService = context.getBean(UserRoleService.class);
		
		//userRoleService.saveUserWithRoles();
        //userRoleService.getUser();
	      userRoleService.getRole();
	}

}
