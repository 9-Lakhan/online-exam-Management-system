package com.controller;

import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.entity.Answer;
import com.entity.Score;

@Controller
public class EndController {
	
    @Autowired
    SessionFactory factory;
	
	@RequestMapping("endexam")
	
	public ModelAndView endexam(HttpServletRequest request) {
		
	HttpSession httpsession=request.getSession();
	
	HashMap<Integer,Answer> map=(HashMap) httpsession.getAttribute("submittedDetails");
	Collection<Answer> AllData = map.values();
	
	for(Answer answer :AllData) 
	{
		if(answer.submittedAnswer.equals(answer.correctAnswer)) {
		httpsession.setAttribute("score",(Integer) httpsession.getAttribute("score")+1);
		}
	}
	
	   Session session=factory.openSession();
	   Transaction tt=session.beginTransaction();
	   Score score=new Score();
	    score.setUsername((String)httpsession.getAttribute("username"));
	    score.setSubject((String)httpsession.getAttribute("subject"));
	    score.setMarks((Integer)httpsession.getAttribute("score"));
	
	   session.save(score);
	   tt.commit();
	
	ModelAndView mv=new ModelAndView();
	mv.setViewName("score");
	mv.addObject("finalScore", httpsession.getAttribute("score"));
	mv.addObject("allData", AllData);
	
	
	httpsession.invalidate();
		return mv;
	}
	@RequestMapping("loginPage")
	public String loginPage() {
		return "login";
		
	}
	
	
}
