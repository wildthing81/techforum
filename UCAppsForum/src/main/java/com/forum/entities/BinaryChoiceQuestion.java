package com.forum.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="questions")
public class BinaryChoiceQuestion extends Question{


	private boolean answer;
	
	public BinaryChoiceQuestion(long qBankID) {
		super(qBankID);
		
	}

	public boolean isAnswer() {
		return answer;
	}

	public void setAnswer(boolean answer) {
		this.answer = answer;
	}
  
}
