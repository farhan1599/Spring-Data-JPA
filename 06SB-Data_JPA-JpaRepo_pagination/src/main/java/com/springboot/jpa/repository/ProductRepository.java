package com.springboot.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.jpa.entity.Product;

//JpaRepo supports SORTING, PAGINATION and QUERY BY EXAMPLE
//By using JpaRepo also we can perform CRUD operations
//JpaRepo = CrudRepo + sorting + pagination + QBE

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
