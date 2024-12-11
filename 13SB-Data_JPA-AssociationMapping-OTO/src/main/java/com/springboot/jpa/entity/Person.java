package com.springboot.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*=================@OneToOne=====================
 * Person -----------------------> Passport
 */

@Entity
@Getter
@Setter
@ToString
@Table(name = "person_tbl")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer personId;
	private String personName;
	private String gender;

}
