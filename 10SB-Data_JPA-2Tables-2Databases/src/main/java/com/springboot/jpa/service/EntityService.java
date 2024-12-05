package com.springboot.jpa.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.jpa.db1.entity.UserEntity;
import com.springboot.jpa.db1.repository.UserRepository;
import com.springboot.jpa.db2.entity.BookEntity;
import com.springboot.jpa.db2.repository.BookRepository;
@Service
public class EntityService {
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private BookRepository bookRepo;
	
	
	public void insertRecord() {
		UserEntity u= new UserEntity();
		u.setId(101);
		u.setName("Allen");
		u.setGender("Male");
		u.setContact(12354678l);
		
		BookEntity b=new BookEntity();
		b.setId(101);
		b.setName("Java");
		b.setPrice(500.0);
		
		userRepo.save(u);
		bookRepo.save(b);
		
		System.out.println("records saved into both databases....");
		
		
	}

}
