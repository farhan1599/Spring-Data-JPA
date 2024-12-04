package com.springboot.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products_list")
public class ProductEntity {
	@Id
	private Integer productId;
	private String productName;
	private Double price;
	private Double rating;

}
