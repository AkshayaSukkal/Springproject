package com.ecomm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecomm.entity.UserDetail;

@Controller
public class PageController 
{
	@RequestMapping("/Login")
	public String showLoginPage()
	{
		System.out.println("LogIn page Created");
		return "Login";
	}
	
	@RequestMapping("/Register")
	public String showRegisterPage(Model m)
	{
		UserDetail userDetail = new UserDetail();
		m.addAttribute("customer", userDetail);
		System.out.println("Register Page Created");
		
		return "Register";
	}
	
}
