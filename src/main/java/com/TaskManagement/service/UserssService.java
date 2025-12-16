package com.TaskManagement.service;

import com.TaskManagement.entity.Userss;

public interface UserssService {

 public String add(Userss userss);
 public String delete(Integer id );
 public String update(Userss userss, Integer id);
 public Userss findEmailPass(String email, String password);
 public Userss findbyEmail(String email); 
 
 
 
}
