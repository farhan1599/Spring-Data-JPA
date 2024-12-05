package com.springboot.jpa.db2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.jpa.db2.entity.BookEntity;

public interface BookRepository extends JpaRepository<BookEntity, Integer> {

}
