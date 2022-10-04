package com.controller;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.entity.Questions;

@Controller
public class AddQuestionController {
	@Autowired
	SessionFactory factory;
     @RequestMapping("addQuestion")
    public ModelAndView addQuetion(Questions u) {
    	 Session sn = factory.openSession();
    	 sn.save(u);
    	 sn.beginTransaction().commit();
    	 sn.close();
    	 ModelAndView mv=new ModelAndView();
    	 mv.addObject("msg","question added successfully..");
    	 mv.setViewName("questionmanagement");
    	 
    	 return mv;
    }
     
     @RequestMapping("viewQuestion")
     public ModelAndView viewQuestion(int qno,String subject) {
    	 
    	 Session session=factory.openSession();
    	 
    	 Query query=session.createQuery("from Questions where qno=:qno and subject=:subject");
    	 query.setParameter("qno",qno);
    	 query.setParameter("subject",subject);
    	 
    	 List<Questions> list=query.list();
    	 Questions questions=list.get(0);
    	 
    	 ModelAndView modelAndView =new ModelAndView();
    	 
    	 modelAndView.setViewName("questionmanagement");
    	 modelAndView.addObject("questions",questions );
    	 modelAndView.addObject("msgg", "question viewed");
    	  
		return modelAndView;
    	 
     }
     @RequestMapping("updateQuestion")
     public ModelAndView updateQuestion(Questions questions) {
    	 
    	 Session session=factory.openSession();
    	 Transaction tt=session.beginTransaction();
    	 
    	 Query<Questions> query=session.createQuery("update Questions set option1=:option1,option2=:option2,option3=:option3,option4=:option4,answer=:answer where qno=:qno and subject=:subject");
    	 
    	 query.setParameter("qno", questions.qno);
    	 query.setParameter("subject",questions.subject);
    	 query.setParameter("option1",questions.option1);
    	 query.setParameter("option2",questions.option2);
    	 query.setParameter("option3",questions.option3);
    	 query.setParameter("option4",questions.option4);
    	 query.setParameter("answer",questions.answer);
    	 
    	 query.executeUpdate();
    	 tt.commit();
    	 
    	 ModelAndView modelAndView=new ModelAndView();
    	 modelAndView.setViewName("questionmanagement");
    	 modelAndView.addObject("msg","question updated");
    	 
		return modelAndView;
     }
     @RequestMapping("deleteQuestion")
     public ModelAndView deleteQuestion(Questions questions) {
    	 Session session=factory.openSession();
    	 Transaction tt=session.beginTransaction();
    	 
    	 Query<Questions> query=session.createQuery("delete Questions where qno=:qno and subject=:subject");
    	 query.setParameter("qno", questions.qno);
    	 query.setParameter("subject",questions.subject);
    	 
    	 query.executeUpdate();
    	 tt.commit();
    	 ModelAndView mv=new ModelAndView();
    	 mv.setViewName("questionmanagement");
    	 mv.addObject("msg", "Deleted successfully");
    	 
		return mv;
    	 
     }
}
