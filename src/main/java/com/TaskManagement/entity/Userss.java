package com.TaskManagement.entity;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Userss {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String name ; 
	@Column(unique = true)
	String email ;
	String password;
	int age ; 
	
	@OneToMany(mappedBy = "userss" , cascade = CascadeType.ALL)
	private List <Task> task ;
	}