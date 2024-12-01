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

//optional (if we don't write @Table name then class name will considered as table name)
@Table(name = "User_Info")
public class User {

	@Id
	@Column(name = "user_id") // optional (variable name will considered as column name )
	private Integer id;
	private String name;
	private String gender;
	private String country;

	/*
	 * for every DB table we need to add "created_date" and "last_updated" columns
	 * to analyze data available in the table
	 */

	@CreationTimestamp // populate record created date
	@Column(updatable = false) // update operation should not happen
	private LocalDate created_date;

	@UpdateTimestamp // populate record updated date
	@Column(insertable = false) // insert operation should not happen
	private LocalDate last_updated;

}
