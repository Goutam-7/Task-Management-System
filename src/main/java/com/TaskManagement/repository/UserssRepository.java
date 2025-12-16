package com.TaskManagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.TaskManagement.entity.Userss;
@Repository
public interface UserssRepository extends JpaRepository<Userss, Integer> {

	Userss findByEmailAndPassword(String email, String password);
	Userss findByEmail(String email);
}
