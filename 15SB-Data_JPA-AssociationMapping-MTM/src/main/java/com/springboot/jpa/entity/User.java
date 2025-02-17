package com.springboot.jpa.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/*===================@ManyToMany=======================
 * multiple Users----------------> multiple Roles
 * In @ManyToMany relationship we'll have 3rd table which is called as "join table"
 * "user_tbl"------> contains users info
 * "role_tbl"------> contains roles info
 * "user_role_tbl"-------> contains userIds and roleIds
 * 
 * */
@Entity
@Getter
@Setter
@Table(name = "user_tbl")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	private String name;
	private String gender;
	
	
	@ManyToMany(
			cascade = CascadeType.ALL,
			fetch = FetchType.EAGER
			)
	
	
	//joins "user_role_tbl"
	@JoinTable(
			name="user_role_tbl",
			
			//adding "user_tbl" primary key column as foreign key in "user_role_tbl"
			joinColumns = {
					@JoinColumn(name="userId")
			},
			
			//adding "role_tbl" primary key column as foreign key in "user_role_tbl"F
			inverseJoinColumns = {
					@JoinColumn(name = "roleId")
			}
			)
	//users have multiple roles
	private List<Role> roles;
	

}
