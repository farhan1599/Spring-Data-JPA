package com.springboot.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.jpa.entity.PersonEntity;

public interface PersonRepository extends JpaRepository<PersonEntity, Integer> {

}
