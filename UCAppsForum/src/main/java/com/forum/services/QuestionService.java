package com.forum.services;

import java.util.List;

import com.forum.entities.Question;
import com.forum.entities.QuestionBank;


public interface QuestionService {

	
	public String createQuestion(String question,String answer);
	
	public String createQuestion(String question,List<String> choices);
	
	public String createQuestion(String question,boolean answer);

	public Question getQuestion(QuestionBank qBank);
	
}
