package com.examprep.helpers;

import com.examprep.entities.Question;
import com.examprep.interfaces.QuestionTypeHelper;
import org.apache.poi.ss.usermodel.Row;

public class BinaryChoiceHelper implements QuestionTypeHelper {

	private String type;

	public BinaryChoiceHelper(String type){
		this.type=type;
	}
	
	@Override
	public Question createQuestion(long qBankID, Row row){
		 
		
	}

}
