package com.springboot.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.jpa.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}
