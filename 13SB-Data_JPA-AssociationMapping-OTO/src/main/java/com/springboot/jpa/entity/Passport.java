package com.springboot.jpa.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*=================@OneToOne=====================
 *  Passport -----------------------> Person
 */

/*Either we can write "personId" in passport_tbl or "passportId" in person_tbl
 * as foreign key because its @OneToOne relationship
 */
@Entity
@ToString
@Getter
@Setter
@Table(name = "passport_tbl")
public class Passport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer passportId;
	private String passportNum;
	private LocalDate issuedAt;
	private LocalDate expireAt;

	@OneToOne // represents type of the relationship
	@JoinColumn(name = "personId") // represents foreign key
	private Person person;

}
