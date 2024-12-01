package com.springboot.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products_list")
public class Product {
	@Id
	private Integer productId;
	private String productName;
	private Double price;
	private Double rating;
	private Integer quantity;

}
