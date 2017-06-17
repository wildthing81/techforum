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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.forum.entities.Answer;
import com.forum.entities.Question;
import com.forum.entities.UCFUserSession;
import com.forum.entities.dto.QuestionDto;
import com.forum.services.AnswerService;
import com.forum.services.QuestionService;

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

	@RequestMapping(value = "/addQuestion.htm", method = RequestMethod.POST)
	public String addQuestion(@ModelAttribute QuestionDto questiondto, Model model) {

		String status = questionService.addQuestion(questiondto);
		model.addAttribute("createstatus", status);
		return "/homepage";

	}

	
	@RequestMapping(value = "/questionList", method = RequestMethod.GET)
	public @ResponseBody List<Question> getAllQuestions(Model model) {

		List<Question> questionList=questionService.getAllQuestions();
		return questionList;
	}
	
	@RequestMapping(value = "/question.htm", method = RequestMethod.GET)
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
