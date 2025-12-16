package com.TaskManagement.controller; 


import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.TaskManagement.entity.Userss;
import com.TaskManagement.repository.UserssRepository;
import com.TaskManagement.service.UserssService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserssController {

	@Autowired
	private UserssService service ;

	@GetMapping("/")
	public String start()
	{
		return "register";
	} 
	
	@GetMapping("/login")
	public String directlogin()
	{
		return "login";
	} 
	
	@PostMapping("/login")
	public String login(Userss user , Model model)
	{
		Userss userss = service.findbyEmail(user.getEmail());
		if(userss==null)	
		{
			model.addAttribute("msg", "Registration Sucessfull");
			service.add(user);
			return "login"; 
		}
		 
		else {
			
			model.addAttribute("msg", "User Alreardy Exists");
			return "login" ; 
		}
	}
	
	@PostMapping("/home")
	public String home(Model model, String email , String password , HttpSession session) 
	{
		Userss userss = service.findEmailPass(email,password);
		if(userss!=null)
		{
			
			 session.setAttribute("user", userss);     
			model.addAttribute("msg", "Login Sucess");
			return "home"; 
			
		}
		else {
			
			model.addAttribute("msg", "Login Failed"); 
			return "login"; 
			
		}
		
		
	}
	
	@GetMapping("/logout")
    public String logout(HttpSession session, Model model) {
        
        session.invalidate(); 

        model.addAttribute("msg", "Logout Successful");

        return "login";
    }
	
	@GetMapping("/home")
	public String getMethodName() {
		
		return "home";
		
	}
	
	
}
