package com.TaskManagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TaskManagement.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer>{

	List<Task> findByUserssId(Integer id);
	
}
 