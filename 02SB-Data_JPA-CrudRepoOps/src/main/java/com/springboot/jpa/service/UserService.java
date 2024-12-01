package com.springboot.jpa.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springboot.jpa.entity.User;
import com.springboot.jpa.repository.UserRepository;

@Service
public class UserService {

	// ======to perform dependency injection=====
	private UserRepository userRepo;

	// performing constructor injection
	// @Autowired is optional here, because there is only one param constructor
	// IOC has to call this constructor in order to create obj and DI will happen

	public UserService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}

	// ===========to insert single record================
	public void saveUser() {
		User user1 = new User();
		user1.setId(101);
		user1.setName("Max");
		user1.setGender("Male");
		user1.setCountry("UK");

		// calling save() from CrudRepository interface
		userRepo.save(user1); // save() to insert a single record
	}

	// =============to insert multiple records======================
	public void saveUsers() {

		User user2 = new User();

		user2.setId(102);
		user2.setName("Allen");
		user2.setGender("Male");
		user2.setCountry("UK");

		User user3 = new User();
		user3.setId(103);
		user3.setName("John");
		user3.setGender("Male");
		user3.setCountry("USA");

		User user4 = new User();
		user4.setId(104);
		user4.setName("Lisa");
		user4.setGender("Female");
		user4.setCountry("USA");

		User user5 = new User();
		user5.setId(105);
		user5.setName("Lily");
		user5.setGender("Female");
		user5.setCountry("Japan");

		// =========storing all user objects into a list===============
		List<User> usersList = Arrays.asList(user2, user3, user4, user5);

		// calling saveAll() from CrudRepository interface
		userRepo.saveAll(usersList); // saveAll() to insert list of records at a time

	}

	//================= to retrieve all records===========================
	public void findAllUsers() {

		// calling findAll() from CrudRepository interface
		Iterable<User> allUsers = userRepo.findAll(); // returns collection of all records
		allUsers.forEach(users -> {
			System.out.println(users);
		});
	}

	//==================== to retrieve a single record by Id(primary key)===========
	public void getUserById(Integer userId) {

		// calling findById() from CrudRepository interface
		Optional<User> byId = userRepo.findById(userId);// returns Optional obj to avoid NullPointerException

		if (byId.isPresent()) { // check if record isPresent
			System.out.println(byId.get());// get the record
		} else {
			System.out.println("No record found !!");
		}

	}

	// ============to delete a record by Id(primary key)=======================
	public void deleteUser(Integer userId) {

		// calling deleteById() from CrudRepository interface
		userRepo.deleteById(userId);
	}

	// =====================to delete all the record at once======================
	public void deleteAllUsers() {

		// calling deleteAll() from CrudRepository interface
		userRepo.deleteAll();
	}

}
