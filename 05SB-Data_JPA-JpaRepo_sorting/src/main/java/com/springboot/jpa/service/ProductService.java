package com.springboot.jpa.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.springboot.jpa.entity.Product;
import com.springboot.jpa.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepo;

//======inserting records into table=================
	public void saveProducts() {

		Product p1 = new Product();
		p1.setProductId(101);
		p1.setProductName("Mobile");
		p1.setPrice(15000.0);
		p1.setRating(4.5);
		p1.setQuantity(5);

		Product p2 = new Product();
		p2.setProductId(102);
		p2.setProductName("Laptop");
		p2.setPrice(125000.0);
		p2.setRating(4.6);
		p2.setQuantity(7);

		Product p3 = new Product();
		p3.setProductId(103);
		p3.setProductName("Speaker");
		p3.setPrice(15000.0);
		p3.setRating(4.5);
		p3.setQuantity(10);

		Product p4 = new Product();
		p4.setProductId(104);
		p4.setProductName("Watch");
		p4.setPrice(1500.0);
		p4.setRating(3.5);
		p4.setQuantity(8);

		Product p5 = new Product();
		p5.setProductId(105);
		p5.setProductName("Shoes");
		p5.setPrice(1500.0);
		p5.setRating(3.5);
		p5.setQuantity(4);

		Product p6 = new Product();
		p6.setProductId(106);
		p6.setProductName("Jackets");
		p6.setPrice(1200.0);
		p6.setRating(4.6);
		p6.setQuantity(15);

		Product p7 = new Product();
		p7.setProductId(107);
		p7.setProductName("TV");
		p7.setPrice(35000.0);
		p7.setRating(4.4);
		p7.setQuantity(3);

		List<Product> productList = Arrays.asList(p1, p2, p3, p4, p5, p6, p7);

		productRepo.saveAll(productList);

		System.out.println("Products saved into database...");

	}

//==========sorting Product price in descending order=======================
	public void sortByPrice() {

		Sort sort = Sort.by("price").descending();
		List<Product> priceLst = productRepo.findAll(sort);
		priceLst.forEach(p -> {
			System.out.println(p);
		});

	}

	// ==========sorting Product rating in descending order=======================
	public void sortByRating() {

		Sort sort = Sort.by("rating").descending();
		List<Product> priceLst = productRepo.findAll(sort);
		priceLst.forEach(p -> {
			System.out.println(p);
		});

	}

}
