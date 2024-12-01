package com.springboot.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.springboot.jpa.entity.Student;
import com.springboot.jpa.repo.StudentRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

		// JPA will provide implementation class
		StudentRepository studentRepo = context.getBean(StudentRepository.class);

		Student student = new Student();

		student.setStudentId(101);
		student.setStudentName("Allen");
		student.setCourseName("Btech");

		// save() method from CrudRepository interface
		studentRepo.save(student);

	}

}
