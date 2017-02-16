/**
 * 
 */
package com.forum.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forum.datalayer.AnswerDao;
import com.forum.entities.Answer;
import com.forum.services.AnswerService;

/**
 * @author asus
 *
 */

@Service
public class AnswerServiceImpl implements AnswerService {

	@Autowired
	private AnswerDao answerDao;
	
	@Override
	public String addAnswer(Answer answer) {
		answerDao.addAnswer(answer);
		return null;
	}

	@Override
	public List<Answer> getAnswersPerQuestion(String questionId) {
		return answerDao.getAnswersPerQuestion(questionId);
	}

	@Override
	public List<Answer> getAnswersPerUser(long userID) {
		return answerDao.getAnswersPerUser(userID);
	}

	@Override
	public List<Answer> getAnswersPerTopic(long topicId) {
		return answerDao.getAnswersPerTopic(topicId);
	}

	@Override
	public Answer getAnswer(long answerId) {
		return answerDao.getAnswer(answerId);
	}

}
