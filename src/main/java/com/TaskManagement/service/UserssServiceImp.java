package com.TaskManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TaskManagement.entity.Userss;
import com.TaskManagement.repository.UserssRepository;

@Service
public class UserssServiceImp implements UserssService {

	@Autowired
	private UserssRepository repository ; 
	
	
	@Override
	public String add(Userss userss) {
		
		Userss save = repository.save(userss);
		return save.getName()+" got saved ";
	}

	@Override 
	public String delete(Integer id) {
		
		Userss us = repository.findById(id).orElseThrow(()-> new RuntimeException("User not found")); 
		
		repository.delete(us);
		
		return" got deleted"; 
	}

	@Override
	public String update(Userss userss , Integer id) {
		
		Userss users = repository.findById(id).orElseThrow(()-> new RuntimeException("User not found"));
		repository.save(userss);
		
		return userss.getName() +" got updated " ;   
	
	}

	@Override
	public Userss findEmailPass(String email, String password) {
		Userss userss = repository.findByEmailAndPassword(email, password);
		
		return userss ; 
		
		
	}
	

	@Override
	public Userss findbyEmail(String email) { 
		
		return repository.findByEmail(email);
	
	}
	
}
