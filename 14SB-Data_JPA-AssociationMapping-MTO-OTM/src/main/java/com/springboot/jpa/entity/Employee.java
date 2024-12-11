package com.springboot.jpa.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/*   ============= @OneToMany ===================
 *      Employee --------------> multiple Addresses
 */

@Entity
@Getter
@Setter
@Table(name = "emp_tbl")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer empId;
	private String name;
	private Double salary;

	@OneToMany(
			// Address is mapped with Employee
			mappedBy = "emp", // doesn't create 3rd table to maintain relationship

			// whatever operation we do on parent should be reflected on child also
			cascade = CascadeType.ALL,

			// if you want parent record along with child record( byDefault :LAZY)
			fetch = FetchType.EAGER

	)
//taking List because one Employee has multiple Addresses
	private List<Address> addr;

}
