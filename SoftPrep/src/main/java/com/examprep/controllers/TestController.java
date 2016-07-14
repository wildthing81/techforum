package com.examprep.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.examprep.datalayer.PracticeTestDao;
import com.examprep.entities.PracticeTest;
import com.examprep.services.GradingService;
import com.examprep.services.TestService;
import com.examprep.services.impl.PracticeTestServiceImpl;

@Controller
public class TestController {
	
	//@Autowired
	//UserSession session
	@Autowired
	PracticeTestDao practiceTestDao;
	@Autowired
	TestService practiceTestService;
	
	
	@RequestMapping(value="/practicetest.htm")
	public String startExam(@RequestParam("streamid") int streamId,
							@RequestParam("questioncount") int questioncount,
							@RequestParam("examduration") long examduration,
							Model model)
	{
		PracticeTest test = new PracticeTest();
		test.setQuestionCount(questioncount);
		test.setTotalTime(examduration);
		test.setStreamID(streamId);
		test.setCurrQuestion(practiceTestService.getFirstQuestion(streamId));
		UserDetails userDetails = null;
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken))
		        userDetails = (UserDetails) auth.getPrincipal();
		
		test.setUserName(userDetails.getUsername());
		long practiceTestId=practiceTestDao.setPracticeTest(test);
		///upload  PracticeTest to user session
		model.addAttribute("test",test );
		return "/practicetest";
		
	}
	
	@RequestMapping(value="/grade.htm")
	public String gradeExam(@RequestParam("testid") int practiceTestId,
									 							Model model)
	{
		
		//long remainingtime=Long.parseLong(duration);
		GradingService gradeService = new GradingService();
		String grade=gradeService.gradeExam();
		
		model.addAttribute("grade", grade);
		return "/endexam";
		
	}
	
	@RequestMapping(value="/feedback.htm")
	public String gradeExam(@RequestParam("questid") int questionId,
							@RequestParam("feedback")String feedback,Model model)
	{
		
		//long remainingtime=Long.parseLong(duration);
		GradingService gradeService = new GradingService();
		String grade=gradeService.gradeExam();
	
		model.addAttribute("grade", grade);
		return "Your feedback has been sent.We will respond shortly!!!";
		
	}
}
