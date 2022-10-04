package com.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.entity.Answer;
import com.entity.Questions;

@Controller
public class QuestionController {
	@Autowired
	SessionFactory sf;

	@RequestMapping("startExam")
	public ModelAndView startExam(String selectedSubject,HttpServletRequest request) {
		Session session=sf.openSession();
		
		HttpSession httpsession= request.getSession();    //............1
		httpsession.setAttribute("qno", 0);               //............2
		httpsession.setAttribute("timeremaining", 601);
		
		Criteria cr=session.createCriteria(Questions.class);
		cr.add(Restrictions.eq("subject",selectedSubject));
	
		List<Questions> list=cr.list();
		
		ModelAndView mv=new ModelAndView();               	
		
		mv.setViewName("question");
		mv.addObject("allData", list);
		mv.addObject("questions", list.get(0));
		httpsession.setAttribute("allquestion", list);               //............3
		
		HashMap<Integer,Answer> hashmap=new HashMap<Integer,Answer>();
		
		httpsession.setAttribute("submittedDetails", hashmap);
		httpsession.setAttribute("score", 0);
		httpsession.setAttribute("subject",selectedSubject);
		
		return mv;
		
	}

	@RequestMapping("next")
	public ModelAndView next(HttpServletRequest request) {
		
		HttpSession httpsession=request.getSession();
		Integer i=(Integer) httpsession.getAttribute("qno");
		
		int nextNo=i+1;
		
	List<Questions> list=(List<Questions>) httpsession.getAttribute("allquestion");
	
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("question");
		
		if(nextNo<list.size()) {
	    Questions questions = list.get(nextNo);
		mv.addObject("questions", questions);
		httpsession.setAttribute("qno", nextNo);
		
		HashMap<Integer,Answer> map=(HashMap) httpsession.getAttribute("submittedDetails");
		
		Answer answer=map.get(questions.qno);
		String previousAnswer="";
		if(answer!=null){
			previousAnswer=answer.getSubmittedAnswer();
		}
		mv.addObject("previousAnswer", previousAnswer);
		}
		else {
			mv.addObject("questions",list.get(list.size()-1));
			mv.addObject("message", "previous button click on");
		}
		return mv;
		
	}
	@RequestMapping("previous")
	public ModelAndView previous(HttpServletRequest request) {
		HttpSession httpsession=request.getSession();
		Integer i = (Integer) httpsession.getAttribute("qno");
		
		int previousNo=i-1;
		
		List<Questions> list=(List<Questions>) httpsession.getAttribute("allquestion");

		ModelAndView mv=new ModelAndView();
		mv.setViewName("question");
		
		if(previousNo>=0) {
			Questions questions=list.get(previousNo);
			mv.addObject("questions", questions);
			httpsession.setAttribute("qno", previousNo);
			
			HashMap<Integer,Answer> map=(HashMap) httpsession.getAttribute("submittedDetails");
			
			Answer answer=map.get(questions.qno);
			String previousAnswer="";
			if(answer!=null){
				previousAnswer=answer.getSubmittedAnswer();
			}
			mv.addObject("previousAnswer", previousAnswer);
		}
		else {
			mv.addObject("questions",list.get(0));
			mv.addObject("message","click on next button");
		}
		return mv;
		
	}
	@RequestMapping("saveAnswer")
	public void savaAnswer(HttpServletRequest request,Answer answer) {
		System.out.println(answer);
		
		HttpSession httpsession=request.getSession();
		List<Questions> list=(List<Questions>) httpsession.getAttribute("allquestion");
		
		for(Questions question:list) {
			
			if(question.qno==answer.qno) {
			String ans=question.answer;
			answer.setCorrectAnswer(ans);
			break;
			}
			
		}
		System.out.println(answer);
		HashMap<Integer,Answer> hashmap=(HashMap<Integer, Answer>) httpsession.getAttribute("submittedDetails");
		
		hashmap.put(answer.qno, answer);
		
		System.out.println(hashmap);	
	}
}
