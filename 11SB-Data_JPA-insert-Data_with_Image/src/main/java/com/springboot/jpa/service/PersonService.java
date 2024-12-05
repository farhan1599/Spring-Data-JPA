package com.springboot.jpa.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.jpa.entity.PersonEntity;
import com.springboot.jpa.repository.PersonRepository;

@Service
public class PersonService {
	@Autowired
	private PersonRepository personRepo;
	
	
	public  PersonEntity savePerson(String name,String gender,Integer age,Long contact,byte[] image)throws Exception {
		PersonEntity person= new PersonEntity();
		person.setName(name);
		person.setGender(gender);
		person.setAge(age);
		person.setContact(contact);
		person.setImage(image);
		
	 return personRepo.save(person);
		
	}

	
	
}
