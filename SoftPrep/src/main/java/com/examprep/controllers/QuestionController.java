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

import com.examprep.entities.BinaryChoiceQuestion;
import com.examprep.entities.FillBlanksQuestion;
import com.examprep.entities.MultiChoiceQuestion;
import com.examprep.services.QuestionService;

/**
 * @author asus
 * 
 */
@Controller
public class QuestionController {

	@Autowired
	private QuestionService questionService;

	@RequestMapping(value = "/question.htm", method = RequestMethod.POST)
	public String createBinaryQuestion(
			@ModelAttribute BinaryChoiceQuestion question, Model model) {

		String status = questionService.createQuestion(question.getQuestion(),
				question.isAnswer());
		model.addAttribute("createstatus", status);
		return "/question";

	}

}
