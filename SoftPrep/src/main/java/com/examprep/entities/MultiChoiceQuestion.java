package com.examprep.entities;

import java.util.ArrayList;
import java.util.List;

public class MultiChoiceQuestion extends Question {

	private List choices=new ArrayList<String>();
	private int choicescount;
	private String answer;
	
	public MultiChoiceQuestion(long qBankID,String type) {
		super(qBankID, type);
		
	}

	public List<String> getChoices() {
		return choices;
	}

	public void setChoices(List<String> choices) {
		this.choices = choices;
		this.choicescount=choices.size();
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	
	public void setChoicescount(int choicescount) {
		this.choicescount = choicescount;
	}

	public int getChoicescount() {
		return choicescount;
	}

	
}
