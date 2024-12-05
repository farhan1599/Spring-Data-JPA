package com.springboot.jpa;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.springboot.jpa.service.PersonService;

@SpringBootApplication
public class Application {
//	
//	 public byte[] readImageFile (String filePath)throws Exception{
//		 Path path = Paths.get("H:\\\\PicsArt/image.jpg");
//		 return Files.readAllBytes(path);
//	 }

	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		PersonService personService = context.getBean(PersonService.class);

		// File file = new File("H:\\PicsArt\\image.jpg");
		byte[] imageBytes = Files.readAllBytes(Paths.get("H:\\\\PicsArt\\\\image.jpg"));

		personService.savePerson("John", "Male", 25, 1234l, imageBytes);
	}

}
