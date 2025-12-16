package com.TaskManagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id ;
	String name ; 
	String duration ; 
	
	@ManyToOne
	private Userss userss ;
	
	
	
}
