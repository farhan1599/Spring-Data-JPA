package com.springboot.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.jpa.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
