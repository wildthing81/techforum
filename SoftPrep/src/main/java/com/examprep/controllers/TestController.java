package com.examprep.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class TestController {
	
	
	
	@RequestMapping(value="/practice.htm",method=RequestMethod.GET)
	public String startPractice(@RequestParam("qbank") String bankName,
									 Model model)
	{
		
		//String status=qbankUploadService.uploadQuestionBank(bankName,bankFile);
		model.addAttribute("uploadstatus", status);
		return "/practicetest";
		
	}

	@RequestMapping(value="/realtest.htm",method=RequestMethod.GET)
	public String startExam(@RequestParam("qbank") String bankName,
									 				Model model)
	{
		
		//String status=qbankUploadService.uploadQuestionBank(bankName,bankFile);
		model.addAttribute("uploadstatus", status);
		return "/realtest";
		
	}
}
