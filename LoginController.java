package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.entity.User;
import com.entity.Users;
import com.service.LoginService;



@Controller
public class LoginController {
	
	@Autowired
	LoginService service;
	
	@Autowired
	SessionFactory sf;
	
	
	@RequestMapping("showRegisterPage")
	public String showRegisterPage()
	{
		return "register";
	}


	@RequestMapping("login")
	public ModelAndView login(User user ,HttpServletRequest request) {
		ModelAndView mv=new ModelAndView();
		
		
		if(user.getUsername().equals("admin") && user.getPassword().equals("admin123")) {
			mv.setViewName("questionmanagement");
		}

		else if(service.validate(user))
			
		{	
			HttpSession session=request.getSession();
			session.setAttribute("username", user.getUsername());
			mv.setViewName("questions");
			mv.addObject("message","welcome " + user.getUsername());
			
		}
		else
		{
			
			mv.setViewName("login");
			mv.addObject("errorMessage","wrong credentials");
		}
		return mv;	
	}
}
