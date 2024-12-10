package com.springboot.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.jpa.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
