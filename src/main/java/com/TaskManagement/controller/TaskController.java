package com.TaskManagement.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.TaskManagement.entity.Task;
import com.TaskManagement.entity.Userss;
import com.TaskManagement.repository.TaskRepository; 
import com.TaskManagement.service.TaskService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService service ;

    @GetMapping("/addtask")
    public String open()
    {
    	return "taskregister";
    }
    
    @PostMapping("/taskadded")
    public String addTask(Task task, HttpSession session)
    {
        Userss u = (Userss) session.getAttribute("user");
        if (u == null) {
            return "login";  
        }
        
       task.setUserss(u);
       

       
        service.add(task);  
        return "home"; 
    }
    
    @GetMapping("/view")
    public String view(HttpSession session , Model model)
    {
    	Userss userss=(Userss)session.getAttribute("user");
    	
    	if(userss != null )
    	{
    		List<Task> tasks=service.findByUserssId(userss.getId());
    		if(!tasks.isEmpty())
    		{
    		model.addAttribute("list", tasks);
    		
    		return "view";
    		}
    		
    		else {
    			model.addAttribute("NotFound", "Add Task And set fire 🔥🐦‍🔥🐦‍🔥🐦‍🔥");
    			return "home";  
    		}
    	}
    	else {
    		
    		model.addAttribute("msg", "Session Expired Login again ");
			
    		return "login";
		}
    	
    }
    
    
//    @GetMapping("/logout")
//    public String logout(HttpSession session, Model model) {
//        
//        session.invalidate(); 
//
//        model.addAttribute("msg", "Logout Successful");
//
//        return "login";
//    }

    
    
    
    


}
