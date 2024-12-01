package com.springboot.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.springboot.jpa.entity.Product;
import com.springboot.jpa.repository.ProductRepository;

@Service
public class ProductService {

	private ProductRepository productRepo;

	@Autowired
	public void setProductRepo(ProductRepository productRepo) {
		this.productRepo = productRepo;
	}

//QBE: used to execute dynamic queries to filter data
	public void getProductQBE(Double rating, Double price) {

		Product product = new Product();
		if (rating != null) {
			product.setRating(rating);
		}
		if (price != null) {
			product.setPrice(price);
		}

		// pass the Product object in Example.of()
		Example<Product> of = Example.of(product);

		// call findAll() and pass the Example object
		List<Product> productLst = productRepo.findAll(of);
		productLst.forEach(products -> {
			System.out.println(products);
		});

	}

}
