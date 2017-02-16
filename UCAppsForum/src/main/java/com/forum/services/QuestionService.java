package com.forum.services;

import java.util.List;

import com.forum.entities.Question;
import com.forum.entities.QuestionBank;


public interface QuestionService {

	
	public String addQuestion(Question question);
	
	public List<Question> getAllQuestions();
	
	public List<Question> getQuestionsPerUser(long userID);
	
	public List<Question> getQuestionsPerTopic(long topicId);
	
	public Question getQuestion(String questionId);
	
}
