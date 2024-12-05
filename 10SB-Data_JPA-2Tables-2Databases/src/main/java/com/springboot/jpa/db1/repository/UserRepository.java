package com.springboot.jpa.db1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.jpa.db1.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

}
