package com.examprep.services;

import org.springframework.stereotype.Service;

@Service
public class GradingService {

	public String gradeExam() {
		 
		int score=10;
		return "you scored"+score;
	}

}
