package com.examprep.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.examprep.datalayer.PracticeTestDao;
import com.examprep.entities.PracticeTest;
import com.examprep.services.GradingService;

@Controller
public class TestController {
	
	
	@RequestMapping(value="/practicetest.htm")
	public String startExam(@RequestParam("streamid") int streamId,
							@RequestParam("questioncount") int questioncount,
							@RequestParam("examlength") long examlength,
							Model model)
	{
		PracticeTest test = new PracticeTest();
		long practiceTestId=new PracticeTestDao().setPracticeTest(test);
		model.addAttribute("testid", practiceTestId);
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
