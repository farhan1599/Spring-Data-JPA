package com.springboot.jpa.repository;

import org.springframework.data.repository.CrudRepository;

import com.springboot.jpa.entity.User;
import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {

	// findBy() name must followed by variable name. eg :findByGender(),
	// findByCountry()

	// findByGender() = select *from user_info where gender =?
	public List<User> findByGender(String gender);

	// findByGenderAndCountry() =select *from user_info where gender=? and country=?
	public List<User> findByGenderAndCountry(String gender, String country);

	// Public List<User> findBySalaryGreaterThanOrEquals(double salary);

	// Public List<User> findBySalaryLessThanOrEquals(double salary);

	// Public List<User> findBySalaryGt(double salary); // greater than

	// Public List<User> findBySalaryGe(double salary); // greater than or equals
}
