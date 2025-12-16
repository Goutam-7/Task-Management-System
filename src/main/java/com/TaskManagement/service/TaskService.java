package com.TaskManagement.service;

import java.util.List;

import com.TaskManagement.entity.Task;

public interface TaskService {

	String add(Task task); 
	String update(Integer id, Task task);
	String delete(Integer id);
	List<Task> findByUserssId(int id);
	
	

}
