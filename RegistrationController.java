package com.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.entity.Users;

@Controller
public class RegistrationController {
	
	@Autowired
	SessionFactory sf;
	
	@RequestMapping("/")
	public String Login() {
		return "login";
				
	}
	@RequestMapping("register")
	public ModelAndView Register(Users user) {
		
		Session session=sf.openSession();
		
		Transaction tt=session.beginTransaction();
		
		session.save(user);
		
		tt.commit();
		
		ModelAndView mv=new ModelAndView();
		
		mv.setViewName("login");
		
		mv.addObject("message", "registration successfully");
		
		return mv;
		
	}
	
}
