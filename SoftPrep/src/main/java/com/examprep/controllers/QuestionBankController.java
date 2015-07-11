/**
 * 
 */
package com.examprep.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.examprep.entities.QuestionBank;
import com.examprep.services.QBankUploadService;

/**
 * Upload questionBank excel to database
 * @author kartik
 *
 */
@Controller
public class QuestionBankController {

	@Autowired
	private QBankUploadService qbankUploadService;
	
	@RequestMapping(value="/qbankupload.htm",method=RequestMethod.POST)
	public String uploadQuestionBank(@ModelAttribute QuestionBank qBank,
									 Model model)
	{
		
		String status=qbankUploadService.uploadQuestionBank(qBank.getqBankName(),qBank.getQbankFile());
		model.addAttribute("uploadstatus", status);
		return "/dashboard";
		
	}
}