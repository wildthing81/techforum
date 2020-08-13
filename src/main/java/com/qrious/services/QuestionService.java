package com.ram.microservice.forum.services;

import java.util.List;

import com.ram.microservice.forum.entities.Question;
import com.ram.microservice.forum.entities.dto.QuestionDto;


public interface QuestionService {

	
	public String addQuestion(QuestionDto questiondto);
	
	public List<Question> getAllQuestions();
	
	public List<Question> getQuestionsPerUser(String userID);
	
	public List<Question> getQuestionsPerTopic(long topicId);
	
	public Question getQuestion(String questionId);
	
}
