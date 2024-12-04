package com.springboot.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.jpa.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

}
