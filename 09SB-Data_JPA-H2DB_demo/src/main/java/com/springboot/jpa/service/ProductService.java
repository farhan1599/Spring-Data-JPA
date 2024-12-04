package com.springboot.jpa.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.jpa.entity.ProductEntity;
import com.springboot.jpa.repository.ProductRepository;

@Service
public class ProductService {

	private ProductRepository productRepo;

	@Autowired
	public void setProductRepo(ProductRepository productRepo) {
		this.productRepo = productRepo;
	}

	public void saveProducts() {
		ProductEntity p = new ProductEntity(101, "Mobile", 15000.0, 4.1);
		ProductEntity p1 = new ProductEntity(102, "TV", 16000.0, 3.6);
		ProductEntity p2 = new ProductEntity(103, "Speaker", 1500.0, 3.5);
		ProductEntity p3 = new ProductEntity(104, "Headphone", 1200.0, 4.0);
		ProductEntity p4 = new ProductEntity(105, "Laptop", 150000.0, 4.5);
		List<ProductEntity> list = Arrays.asList(p, p1, p2, p3, p4);
		productRepo.saveAll(list);
	}

}
