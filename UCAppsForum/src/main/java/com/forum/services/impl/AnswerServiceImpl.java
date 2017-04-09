/**
 * 
 */
package com.forum.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forum.datalayer.AnswerDao;
import com.forum.entities.Answer;
import com.forum.entities.Question;
import com.forum.entities.dto.AnswerDto;
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
	public String addAnswer(AnswerDto answerdto) {
		Answer answer=new Answer();
		answerDao.addAnswer(answer);
		return null;
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
