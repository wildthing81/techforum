/**
 * 
 */
package com.forum.controllers;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;

import com.forum.entities.Answer;
import com.forum.entities.Question;
import com.forum.entities.UCFUserSession;
import com.forum.entities.dto.AnswerDto;
import com.forum.entities.dto.QuestionDto;
import com.forum.services.AnswerService;
import com.forum.services.QuestionService;

/**
 * @author asus
 * 
 */
@Controller
public class AnswerController {

	@Autowired
	UCFUserSession userSession;
	@Autowired
	private AnswerService answerService;

	@PostMapping("/addAnswer.htm")
	public String addAnswer(@ModelAttribute AnswerDto answerdto, Model model) {

		UserDetails userdetails=(UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String answerId = answerService.addAnswer(answerdto,userdetails.getUsername());
		List<Answer> answers=answerService.getAllAnswersForQuestion(answerdto.getQuestionId());
		model.addAttribute("answers", answers);
		model.addAttribute("loginTime",userSession.getLoginTime());
		model.addAttribute("user", userSession.getUserName());
		
		return "/question";

	}

	
	@GetMapping("/answerList")
	public @ResponseBody List<Answer> getAllAnswersForQuestion(String questionId,Model model) {

		List<Answer> answerList=answerService.getAllAnswersForQuestion(questionId);
		return answerList;
	}
	
	@GetMapping("/answer.htm")
	public  String getAnswer(@RequestParam String answerId,Model model) {

		Answer answer=answerService.getAnswer(answerId);
		model.addAttribute("answer", answer);
		//List<Comments> comments=feedbackController.getComments(answerId);
		//List<Upvotes> upvotes=feedbackController.getUpvotes(answerId);
		//model.addAttribute("upvotes", upvotes);
		//model.addAttribute("comments",comments);
		return "/answer";
	}
}
