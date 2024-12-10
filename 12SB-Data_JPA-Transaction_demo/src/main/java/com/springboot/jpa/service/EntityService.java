package com.springboot.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.jpa.entity.Contact;
import com.springboot.jpa.entity.Person;
import com.springboot.jpa.repository.ContactRepository;
import com.springboot.jpa.repository.PersonRepository;

import jakarta.transaction.Transactional;

@Service
public class EntityService {

	@Autowired
	private PersonRepository personRepo;

	@Autowired
	private ContactRepository contactRepo;

// In Data JPA Transactions will be auto commited when we call save()
// If any exception occur in the middle of the method then transaction will
// not complete successfully(one query will execute and other will not execute)
//By configuring @Transactional we'll achieve Atomicity
// (All the operation should be performed successfully or no operation should be performed)

	@Transactional(rollbackOn = Exception.class) // if exception occur it'll rollBack
	public void savePersonWithContact() {

		Person person = new Person();

		person.setName("Allen");
		person.setGender("Male");
		person.setAge(25);
		person.setCountry("UK");

		personRepo.save(person);

		// Arithmetic exception
		int i = 5 / 0;

		Contact contact = new Contact();

		contact.setName("Allen");
		contact.setEmail("allen@gmail.com");
		contact.setPhone(12345679l);

		contactRepo.save(contact);

	}
}
