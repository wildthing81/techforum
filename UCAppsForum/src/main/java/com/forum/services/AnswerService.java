package com.forum.services;

import java.util.List;

import com.forum.entities.Answer;
import com.forum.entities.Question;
import com.forum.entities.dto.AnswerDto;


public interface AnswerService {

	
	public List<Answer> getAnswersPerUser(String userID);
	
	public List<Answer> getAnswersPerTopic(long topicId);

	public Answer getAnswer(String answerId);

	public String addAnswer(AnswerDto answerdto,String userName);

	public List<Answer> getAllAnswersForQuestion(String questionId);

}
