/**
 * 
 */
package com.forum.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forum.datalayer.QuestionDao;
import com.forum.entities.Question;
import com.forum.services.QuestionService;

/**
 * @author asus
 *
 */

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionDao questionDao;
	
	@Override
	public String addQuestion(Question question) {
		questionDao.addQuestion(question);
		return null;
	}

	@Override
	public List<Question> getAllQuestions() {
		return questionDao.getAllQuestions();
	}

	@Override
	public List<Question> getQuestionsPerUser(long userID) {
		return questionDao.getQuestionsPerUser(userID);
	}

	@Override
	public List<Question> getQuestionsPerTopic(long topicId) {
		return questionDao.getQuestionsPerTopic(topicId);
	}

	@Override
	public Question getQuestion(long questionId) {
		return questionDao.getQuestion(questionId);
	}

}
