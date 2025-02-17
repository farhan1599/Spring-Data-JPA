package com.springboot.jpa.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.jpa.entity.Role;
import com.springboot.jpa.entity.User;
import com.springboot.jpa.repository.RoleRepository;
import com.springboot.jpa.repository.UserRepository;

@Service
public class UserRoleService {

	@Autowired
	private UserRepository userRepo;
	@Autowired
	private RoleRepository roleRepo;

//==============inserting user with roles================================
	public void saveUserWithRoles() {
		Role role1 = new Role();
		role1.setRoleName("Manager");

		Role role2 = new Role();
		role2.setRoleName("Admin");

		User user = new User();
		user.setName("Smith");
		user.setGender("Male");

		List<Role> rolesList = Arrays.asList(role1, role2);

		// setting roles to the user
		user.setRoles(rolesList);

		userRepo.save(user);
	}

//====================Getting User by Id===================================

	/*
	 * It will give "user_tbl" along with "role_tbl" and "user_role_tbl" records
	 * because of "FetchType.EAGER" it will perform left join
	 */
	public void getUser() {
		Optional<User> byId = userRepo.findById(2);
		if (byId.isPresent()) {
			System.out.println(byId.get());
		}
	}

//=====================Getting Role by Id===================================

	//it'll give only role records
	
	public void getRole() {
		Optional<Role> byId = roleRepo.findById(1);
		if (byId.isPresent()) {
			System.out.println(byId.get());
		}
	}

}
