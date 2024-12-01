package com.springboot.jpa.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
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

	@CreationTimestamp
	@Column(updatable = false)
	private LocalDate created_date;

	@UpdateTimestamp
	@Column(insertable = false)
	private LocalDate last_updated;

}
