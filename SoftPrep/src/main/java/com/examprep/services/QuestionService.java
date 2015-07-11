package com.examprep.services;

import java.util.List;

import org.springframework.stereotype.Service;


public interface QuestionService {

	
	public String createQuestion(String question,String answer);
	
	public String createQuestion(String question,List<String> choices);
	
	public String createQuestion(String question,boolean answer);
	
}
