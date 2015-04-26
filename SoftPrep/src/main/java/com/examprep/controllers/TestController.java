package com.examprep.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.examprep.services.GradingService;

@Controller
public class TestController {
	
	
	
	@RequestMapping(value="/practice.htm",method=RequestMethod.GET)
	public String startPractice(@RequestParam("qbank") String bankName,
									 Model model)
	{
		model.addAttribute("uploadstatus", status);
		return "/practicetest";
		
	}

	@RequestMapping(value="/realtest.htm",method=RequestMethod.GET)
	public String startExam(@RequestParam("qbank") String bankName,
									 				Model model)
	{
		
		model.addAttribute("uploadstatus", status);
		return "/realtest";
		
	}
	
	@RequestMapping(value="/grade.htm",method=RequestMethod.POST,params=())
	public String gradeExam(@RequestParam("duration") String duration,
									 							Model model)
	{
		
		long remainingtime=Long.parseLong(duration);
		GradingService gradeService = new GradingService();
		gradeService.gradeExam();
		
		model.addAttribute("grade", grade);
		return "/endexam";
		
	}
}
