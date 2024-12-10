package com.springboot.jpa.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.jpa.entity.Passport;
import com.springboot.jpa.entity.Person;
import com.springboot.jpa.repository.PassportRepository;
import com.springboot.jpa.repository.PersonRepository;

@Service
public class PassportService {

	@Autowired
	private PersonRepository personRepo;
	@Autowired
	private PassportRepository passportRepo;

//inserting the data into person_tbl and passport_tbl	
	public void saveData() {

		Person person = new Person();
		person.setPersonName("Allen");
		person.setGender("Male");

//We'll set savedPerson into Passport because savedPerson object will have person_id		
		Person savedPerson = personRepo.save(person);

		Passport passport = new Passport();
		passport.setPassportNum("AJKY5265F");
		passport.setIssuedAt(LocalDate.now()); // current system date
		passport.setExpireAt(LocalDate.now().plusYears(10)); // current date +10 years

		passport.setPerson(savedPerson); // setting savedPerson obj into Passport

		passportRepo.save(passport);
	}

//========================Getting Person records======================================	

	/*
	 * Only Person data will come because Person doesn't have any relation with
	 * Passport The relation is "unidirectional"(Person doesn't have passport_id,
	 * Passport has person_id)
	 */
	public void getPerson() {
		Optional<Person> byId = personRepo.findById(2);
		if (byId.isPresent()) {
			System.out.println(byId.get());
		}
	}

//=======================Getting Passport records=========================================

	/*
	 * Passport will come along with Person. It is using "LEFT JOIN" Left Join :(All
	 * the records from left table and matching records from right table we'll get)
	 */

	public void getPassport() {
		Optional<Passport> byId = passportRepo.findById(1);
		if (byId.isPresent()) {
			System.out.println(byId.get());
		}
	}

//======================Deleting Person record==================================	

	/*
	 * Its will give "ConstraintsVoilationException". Directly we can't delete
	 * Person(parent) when Passport(child) is having the reference with the
	 * Person(parent)
	 * 
	 * First delete the Passport(child) then delete the Person(parent)
	 */

	public void deletePerson() {
		personRepo.deleteById(1);
	}

//=====================Deleting Passport record===================================

	// We can delete Passport(child) directly

	public void deletePassport() {
		passportRepo.deleteById(2);

	}

}
