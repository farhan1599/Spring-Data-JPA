package com.springboot.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/*================== @ManyToOne ======================
 * multiple Addresses ----------------> Employee
 */
@Entity
@Getter
@Setter
@Table(name = "addr_tbl")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer addrId;
	private String city;
	private String state;
	private String type;

	@ManyToOne
	@JoinColumn(name = "empId") // foreign key
	private Employee emp;

}
