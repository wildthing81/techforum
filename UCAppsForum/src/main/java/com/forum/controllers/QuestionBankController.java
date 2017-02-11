/**
 * 
 */
package com.forum.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.forum.entities.QuestionBank;
import com.forum.services.QuestionBankService;

/**
 * Upload questionBank excel to database
 * @author kartik
 *
 */
@Controller
public class QuestionBankController {

	@Autowired
	private QuestionBankService qbankUploadService;
	
	@RequestMapping(value="/qbankupload.htm",method=RequestMethod.POST)
	public String uploadQuestionBank(@ModelAttribute QuestionBank qBank,
									 Model model)
	{
		
		String status=qbankUploadService.uploadQuestionBank(qBank.getQBankName(),qBank.getQbankFile());
		model.addAttribute("uploadstatus", status);
		return "/dashboard";
		
	}
}