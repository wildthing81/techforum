/**
 * 
 */
package com.ram.microservice.forum.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ram.microservice.forum.datalayer.QuestionDao;
import com.ram.microservice.forum.entities.Question;
import com.ram.microservice.forum.entities.dto.QuestionDto;
import com.ram.microservice.forum.services.QuestionService;

/**
 * @author asus
 *
 */

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionDao questionDao;
	
	@Override
	public String addQuestion(QuestionDto questiondto) {
		Question question=new Question();
		question.setQuestion(questiondto.getQuestion());
		question.setqBankID(questiondto.getqBankID());
		questionDao.addQuestion(question);
		return question.getQuestionId();
	}

	@Override
	public List<Question> getAllQuestions() {
		return questionDao.getAllQuestions();
	}

	@Override
	public List<Question> getQuestionsPerUser(String userID) {
		return questionDao.getQuestionsPerUser(userID);
	}

	@Override
	public List<Question> getQuestionsPerTopic(long topicId) {
		return questionDao.getQuestionsPerTopic(topicId);
	}

	@Override
	public Question getQuestion(String questionId) {
		return questionDao.getQuestion(questionId);
	}

}
