/**
 * 
 */
package com.examprep.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.examprep.QBankUploadService;

/**
 * @author kartik
 *
 */
@Controller
public class QuestionBankController {

	@Autowired
	private QBankUploadService qbankUploadService;
	
	@RequestMapping('/qbankupload',method=RequestMethod.POST)
	public String uploadQuestionBank(@RequestParam("qbank") String bankName,
									 @RequestParam("qbankfile") MultipartFile bankFile,
									 Model model)
	{
		
		QBankUploadService.uploadQuestionBank(bankName,bankFile);
		model.addAttribute("message", "success");
		return "/dashboard";
		
	}