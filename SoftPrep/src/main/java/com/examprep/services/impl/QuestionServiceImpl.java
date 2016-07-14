/**
 * 
 */
package com.examprep.services.impl;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examprep.datalayer.QuestionBankDao;
import com.examprep.datalayer.QuestionDao;
import com.examprep.entities.Question;
import com.examprep.entities.QuestionBank;
import com.examprep.services.QuestionService;

/**
 * @author asus
 *
 */

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionDao questionDao;
	
	@Override
	public String createQuestion(String question, String answer) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.examprep.services.QuestionService#createQuestion(java.lang.String, java.util.List)
	 */
	@Override
	public String createQuestion(String question, List<String> choices) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.examprep.services.QuestionService#createQuestion(java.lang.String, boolean)
	 */
	@Override
	public String createQuestion(String question, boolean answer) {
		
		return null;
	}

	@Override
	public Question getQuestion(QuestionBank qBank) {
		int questionCount=qBank.getQBankCount();	
		Question question=questionDao.getQuestion(qBank.getQBankID(),new Random().nextInt(questionCount));
		return question;
	}

}
