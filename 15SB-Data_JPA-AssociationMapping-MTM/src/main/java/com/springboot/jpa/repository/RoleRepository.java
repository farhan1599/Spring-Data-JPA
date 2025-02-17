package com.springboot.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.jpa.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
