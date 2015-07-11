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

import com.examprep.entities.BinaryChoiceQuestion;
import com.examprep.entities.FillBlanksQuestion;
import com.examprep.entities.MultiChoiceQuestion;
import com.examprep.entities.Question;
import com.examprep.entities.QuestionBank;
import com.examprep.services.QBankUploadService;
import com.examprep.services.QuestionService;

/**
 * @author asus
 * 
 */
@Controller
public class QuestionController {

	@Autowired
	private QuestionService questionService;

	@RequestMapping(value = "/binary.htm", method = RequestMethod.POST)
	public String createBinaryQuestion(
			@ModelAttribute BinaryChoiceQuestion question, Model model) {

		String status = questionService.createQuestion(question.getQuestion(),
				question.isAnswer());
		model.addAttribute("createstatus", status);
		return "/dashboard";

	}

	@RequestMapping(value = "/fillblanks.htm", method = RequestMethod.POST)
	public String createFillBlanksQuestion(
			@ModelAttribute FillBlanksQuestion question, Model model) {

		String status = questionService.createQuestion(question.getQuestion(),
				question.getAnswer());
		model.addAttribute("createstatus", status);
		return "/dashboard";

	}

	@RequestMapping(value = "/multichoice.htm", method = RequestMethod.POST)
	public String createMultiChoiceQuestion(
			@ModelAttribute MultiChoiceQuestion question, Model model) {

		String status = questionService.createQuestion(question.getQuestion(),
				question.getChoices());
		model.addAttribute("createstatus", status);
		return "/dashboard";

	}
}
