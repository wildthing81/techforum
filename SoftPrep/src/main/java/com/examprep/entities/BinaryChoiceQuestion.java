package com.examprep.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="questions")
public class BinaryChoiceQuestion extends Question{

	@Id
	private long id;
	
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
