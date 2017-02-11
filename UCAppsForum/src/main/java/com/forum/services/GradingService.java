package com.forum.services;

import org.springframework.stereotype.Service;

@Service
public class GradingService {

	public String rankUser() {
		 
		int score=10;
		return "you scored"+score;
	}

}
