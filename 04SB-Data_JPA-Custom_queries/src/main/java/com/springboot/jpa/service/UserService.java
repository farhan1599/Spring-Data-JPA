package com.springboot.jpa.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.jpa.entity.User;
import com.springboot.jpa.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;

	// ===================to store/save a single user record===================
	public void saveOneUser(Integer id, String name, String gender, String country) {
		User user1 = new User();
		user1.setId(id);
		user1.setName(name);
		user1.setGender(gender);
		user1.setCountry(country);
		userRepo.saveUserHQL(id,name,gender,country);
		System.out.println("One user inserted...");
	}

//	===========to store/save multiple users record===========================
	//===========*THIS METHOD IS INCOMPLETED*==========================
//	public void saveMultipleUsers(Integer id, String name, String gender, String country) {
//		User user2 = new User();
//		user2.setId(id);
//		user2.setName(name);
//		user2.setGender(gender);
//		user2.setCountry(country);
//
//		User user3 = new User();
//		user3.setId(id);
//		user3.setName(name);
//		user3.setGender(gender);
//		user3.setCountry(country);
//
//		User user4 = new User();
//		user4.setId(id);
//		user4.setName(name);
//		user4.setGender(gender);
//		user4.setCountry(country);
//
//		List<User> userList = Arrays.asList(user2, user3, user4);
//		
//	}

	// =============to retrieve all the Users record=======================
	public void getUsers() {
		List<User> allUsers = userRepo.getAllUsers();
		allUsers.forEach(user -> {
			System.out.println(user);
		});
	}

	// =============to update a User record==================
	public void UpdateCountry(String country, Integer id) {
		userRepo.UpdateUser(country, id);
		System.out.println("Updated...");
	}

	// ===============to delete a single User record by userId===================
	public void deleteUserById(Integer id) {
		userRepo.deleteUserById(id);
		System.out.println("Deleted...");
	}

}
