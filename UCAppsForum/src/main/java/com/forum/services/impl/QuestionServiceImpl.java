/**
 * 
 */
package com.forum.services.impl;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forum.datalayer.QuestionDao;
import com.forum.entities.Question;
import com.forum.entities.QuestionBank;
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
	public String addQuestion(String question) {
		// TODO Auto-generated method stub
		return null;
	}

	/*@Override
	public Question getQuestion(QuestionBank qBank) {
		int questionCount=qBank.getQBankCount();	
		Question question=questionDao.getQuestion(qBank.getQBankID(),new Random().nextInt(questionCount));
		return question;
	}*/

}
