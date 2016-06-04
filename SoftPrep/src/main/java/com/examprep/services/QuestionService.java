package com.examprep.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.examprep.entities.Question;
import com.examprep.entities.QuestionBank;


public interface QuestionService {

	
	public String createQuestion(String question,String answer);
	
	public String createQuestion(String question,List<String> choices);
	
	public String createQuestion(String question,boolean answer);

	public Question getQuestion(QuestionBank qBank);
	
}
