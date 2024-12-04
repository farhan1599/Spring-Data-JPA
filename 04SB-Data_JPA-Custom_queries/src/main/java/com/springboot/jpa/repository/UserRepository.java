package com.springboot.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.springboot.jpa.entity.User;

import jakarta.transaction.Transactional;

public interface UserRepository extends CrudRepository<User, Integer> {

	// to insert a record using custom query (HQL)
	@Modifying // :Marks the query as modifying the database (update, delete,insert).
	@Transactional // :Ensures the query is executed within a transaction.
	@Query("insert into User (id,name,gender,country) values(:id,:name,:gender,:country)")
	public void saveUserHQL(Integer id, String name, String gender, String country);

	// =======to insert multiple record using custom query (HQL)================

	// ===========*THIS METHOD IS INCOMPLETED*==========================
//	@Modifying // :Marks the query as modifying the database (update, delete,insert).
//	@Transactional // :Ensures the query is executed within a transaction.
//	@Query("insert into User (id,name,gender,country) values(:id,:name,:gender,:country)")
//	public void saveUsers(Integer id, String name, String gender, String country);

	// ==========to update a record using custom query (HQL)============
	@Modifying
	@Transactional
	@Query("Update User u SET u.country = :country where u.id=:id")
	public void UpdateUser(String country, Integer id);

	// ========to delete a User by userId using a custom query (HQL)===============

	@Modifying
	@Transactional
	@Query("DELETE from User u WHERE u.id=:id")
	public void deleteUserById(Integer id);

	// ===========to get all the records using custom query (HQL)==================
	@Query("From User")
	public List<User> getAllUsers();

//==========we can also write native SQL queries by setting(nativeQuery=true)=======
	// @Query(value = "select * from user_info", nativeQuery = true)
	// public List<User> getAllUsersSQL();

}
