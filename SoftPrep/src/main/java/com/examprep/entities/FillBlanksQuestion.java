package com.examprep.entities;

import java.util.List;

public class FillBlanksQuestion extends Question {

    private List<String> answer;
	
	public FillBlanksQuestion(long qBankID,String type) {
		super(qBankID, type);
		
	}

	public List<String> getAnswer() {
		return answer;
	}

	public void setAnswer(List<String> answer) {
		this.answer = answer;
	}

	
}
