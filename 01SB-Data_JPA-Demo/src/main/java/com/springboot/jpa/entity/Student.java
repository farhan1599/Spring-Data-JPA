package com.springboot.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Student {
	@Id
	private Integer studentId;
	private String studentName;
	private String courseName;

}
