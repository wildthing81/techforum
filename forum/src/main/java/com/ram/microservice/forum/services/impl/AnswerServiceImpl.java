/**
 * 
 */
package com.ram.microservice.forum.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ram.microservice.forum.datalayer.AnswerDao;
import com.ram.microservice.forum.entities.Answer;
import com.ram.microservice.forum.entities.dto.AnswerDto;
import com.ram.microservice.forum.services.AnswerService;

/**
 * @author asus
 *
 */

@Service
public class AnswerServiceImpl implements AnswerService {

	@Autowired
	private AnswerDao answerDao;
	
	@Override
	public String addAnswer(AnswerDto answerdto,String userName) {
		Answer answer=new Answer();
		answer.setAnswer(answerdto.getAnswer());
		answer.setQuestionId(answerdto.getQuestionId());
		answer.setUserName(userName);
		answerDao.addAnswer(answer);
		return answer.getAnswerId();
	}

	@Override
	public List<Answer> getAllAnswersForQuestion(String questionId) {
		return answerDao.getAnswersPerQuestion(questionId);
	}

	@Override
	public List<Answer> getAnswersPerUser(String userID) {
		return answerDao.getAnswersPerUser(userID);
	}

	@Override
	public List<Answer> getAnswersPerTopic(long topicId) {
		return answerDao.getAnswersPerTopic(topicId);
	}

	@Override
	public Answer getAnswer(String answerId) {
		return answerDao.getAnswer(answerId);
	}

}
