package com.springboot.jpa.repo;

import org.springframework.data.repository.CrudRepository;

import com.springboot.jpa.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {

}
