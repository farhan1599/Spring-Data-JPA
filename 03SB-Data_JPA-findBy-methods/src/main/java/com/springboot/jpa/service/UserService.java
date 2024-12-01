package com.springboot.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.jpa.entity.User;
import com.springboot.jpa.repository.UserRepository;

@Service
public class UserService {

	private UserRepository userRepo;

	@Autowired
	public void setUserRepo(UserRepository userRepo) {
		this.userRepo = userRepo;
	}

//===========to get users based on gender========================
	public void getUsersByGender(String gender) {
		List<User> byGender = userRepo.findByGender(gender); // calling findByGender()
		byGender.forEach(user -> {
			System.out.println(user);
		});
	}

	// ===========to get users based on gender and country========================
	public void getUsersByGenderAndCountry(String gender, String country) {

		List<User> byGenderAndCountry = userRepo.findByGenderAndCountry(gender, country);
		byGenderAndCountry.forEach(System.out::println);

	}

}
