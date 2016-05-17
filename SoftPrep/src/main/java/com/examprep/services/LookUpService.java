package com.examprep.services;

import java.util.List;
import java.util.Map;


public interface LookUpService {

	
	public Map<Integer,String> getStreams();
	
	public List<Integer> getQuestionCount();
	
	public List<Long> getExamDuration();
	
}
