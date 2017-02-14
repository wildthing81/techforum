/**
 * 
 */
package com.forum.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.forum.entities.Question;
import com.forum.services.QuestionService;

/**
 * @author asus
 * 
 */
@Controller
public class QuestionController {

	@Autowired
	private QuestionService questionService;

	@RequestMapping(value = "/addQuestion.htm", method = RequestMethod.POST)
	public String addQuestion(@ModelAttribute Question question, Model model) {

		String status = questionService.addQuestion(question);
		model.addAttribute("createstatus", status);
		return "/homepage";

	}

	
	@RequestMapping(value = "/questionList", method = RequestMethod.GET)
	public @ResponseBody List<Question> getAllQuestions(Model model) {

		List<Question> questionList=questionService.getAllQuestions();
		return questionList;
	}
}
