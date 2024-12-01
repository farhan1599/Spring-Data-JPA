package com.springboot.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

	public void getProductPagination() {

		int pageSize = 3; // number of records you want to display in a page
		int pageNo = 1; // default page number

		// (pageNo-1) because database page index starts from 0 index.
		PageRequest of = PageRequest.of(pageNo - 1, pageSize);

		// call findAll() and pass the PageRequest object
		Page<Product> all = productRepo.findAll(of);// pre-defined method

		// call getContent() and print the content
		List<Product> content = all.getContent(); // pre-defined method

		content.forEach(page -> {
			System.out.println(page);
		});

	}

}
