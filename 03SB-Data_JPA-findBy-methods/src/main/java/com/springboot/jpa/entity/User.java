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
@Table(name = "User_info")
public class User {
	@Id
	@Column(name = "user_id")
	private Integer id;
	private String name;
	private String gender;
	private String country;

	/*
	 * @CreationTimestamp
	 * 
	 * @Column(updatable = false) private LocalDate createDate;
	 * 
	 * @UpdateTimestamp
	 * 
	 * @Column(insertable = false) private LocalDate lastUpdate;
	 */
}
