package com.examprep.entities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="questions")
public class FillBlanksQuestion extends Question{

	@Id
	private long id;
	
    private String answer;
    private int blankscount;
    private List<String> choices=new ArrayList<String>();
	
	public FillBlanksQuestion(long qBankID,String type) {
		super(qBankID, type);
		
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	
	public void setBlankscount(int blankscount) {
		this.blankscount = blankscount;
	}

	public int getBlankscount() {
		return blankscount;
	}

	public List<String> getChoices() {
		return choices;
	}

	public void setChoices(List<String> choices) {
		this.choices = choices;
	}

	
}
