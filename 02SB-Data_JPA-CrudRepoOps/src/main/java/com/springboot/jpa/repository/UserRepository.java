package com.springboot.jpa.repository;

import org.springframework.data.repository.CrudRepository;

import com.springboot.jpa.entity.User;

/*creating UserRepository by extending CrudRepository 
 * to call the CrudRepository methods in order to perform DB operations 
 */

public interface UserRepository extends CrudRepository<User, Integer> {

}
