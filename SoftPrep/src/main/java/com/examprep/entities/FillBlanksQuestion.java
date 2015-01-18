package com.examprep.entities;

import java.util.List;

import com.examprep.entities.Question;

public class FillBlanksQuestion extends Question {

    private List<String> answer;
    private int blankscount;
	
	public FillBlanksQuestion(long qBankID,String type) {
		super(qBankID, type);
		
	}

	public List<String> getAnswer() {
		return answer;
	}

	public void setAnswer(List<String> answer) {
		this.answer = answer;
	}

	
	public void setBlankscount(int blankscount) {
		this.blankscount = blankscount;
	}

	public int getBlankscount() {
		return blankscount;
	}

	
}
