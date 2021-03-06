/**
 * 
 */
package com.ram.microservice.forum.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ram.microservice.forum.entities.Answer;
import com.ram.microservice.forum.entities.Question;
import com.ram.microservice.forum.entities.UCFUserSession;
import com.ram.microservice.forum.entities.dto.QuestionDto;
import com.ram.microservice.forum.services.AnswerService;
import com.ram.microservice.forum.services.QuestionService;

/**
 * @author asus
 * 
 */
@Controller
public class QuestionController {

	@Autowired
	private QuestionService questionService;
	@Autowired
	private AnswerService answerService;
	@Autowired
	UCFUserSession userSession;

	@PostMapping("/addQuestion.htm")
	public String addQuestion(@ModelAttribute QuestionDto questiondto, Model model) {

		String status = questionService.addQuestion(questiondto);
		model.addAttribute("createstatus", status);
		return "/homepage";

	}

	
	@GetMapping("/questionList")
	public @ResponseBody List<Question> getAllQuestions(Model model) {

		List<Question> questionList=questionService.getAllQuestions();
		return questionList;
	}
	
	@GetMapping("/question.htm")
	public  String getQuestion(@RequestParam String questionId,Model model) {

		Question question=questionService.getQuestion(questionId);
		model.addAttribute("question", question);
		List<Answer> answers=answerService.getAllAnswersForQuestion(questionId);
		model.addAttribute("answers", answers);
		model.addAttribute("loginTime",userSession.getLoginTime());
		model.addAttribute("user", userSession.getUserName());
		return "/question";
	}
}
