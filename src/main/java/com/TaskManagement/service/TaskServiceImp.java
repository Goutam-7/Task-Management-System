 package com.TaskManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TaskManagement.entity.Task;
import com.TaskManagement.repository.TaskRepository;

@Service
public class TaskServiceImp implements TaskService {

	@Autowired
	private TaskRepository repository ;
	
	@Override
	public String add(Task task) {
		
		Task save = repository.save(task); 
		
		return save.getName() +" task added " ;   
	}

	@Override
	public String update(Integer id , Task task ) {
		
		Task t = repository.findById(id).orElseThrow(()-> new RuntimeException("Task not found"));
		
		Task save = repository.save(task);
		
		return save.getName()+" is updated ";  

	}

	@Override
	public String delete(Integer id) {
		
		Task task = repository.findById(id).orElseThrow(()-> new RuntimeException("Task not found"));
		
		repository.delete(task);
		
		return " Task got deleted" ; 
		
	}

	@Override
	public List<Task> findByUserssId(int id) { 
		List<Task> list = repository.findByUserssId(id);
		
		return list; 
	}
	
	
	

}
