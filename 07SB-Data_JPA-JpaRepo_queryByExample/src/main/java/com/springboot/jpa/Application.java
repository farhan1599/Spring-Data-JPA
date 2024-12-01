package com.springboot.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.springboot.jpa.service.ProductService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		ProductService productService = context.getBean(ProductService.class);
		
		//========filters products with rating 4.5 only============
		//productService.getProductQBE(4.5, null);
		
		
		//=======filters products with rating 4.5 and price 15000
		productService.getProductQBE(4.5, 15000.0);
	}

}
