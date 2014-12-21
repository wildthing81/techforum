package com.examprep.entities;

import java.util.ArrayList;
import java.util.List;

public class BinaryChoiceQuestion extends Question {

	private boolean answer;
	
	public BinaryChoiceQuestion(long qBankID,String type) {
		super(qBankID, type);
		
	}

	public boolean isAnswer() {
		return answer;
	}

	public void setAnswer(boolean answer) {
		this.answer = answer;
	}
  
}
