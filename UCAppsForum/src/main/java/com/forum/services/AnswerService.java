package com.forum.services;

import java.util.List;

import com.forum.entities.Answer;


public interface AnswerService {

	public String addAnswer(Answer answer);
	
	public Answer getAnswer(long answerId);
	
	public List<Answer> getAnswersPerQuestion(long questionId);
	
	public List<Answer> getAnswersPerUser(long userID);
	
	public List<Answer> getAnswersPerTopic(long topicId);
}
