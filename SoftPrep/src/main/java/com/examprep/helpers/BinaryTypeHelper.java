package com.examprep.helpers;

import com.examprep.entities.Question;
import com.examprep.interfaces.QuestionTypeHelper;
import org.apache.poi.ss.usermodel.Row;

public class BinaryTypeHelper implements QuestionTypeHelper {

	private String type;

	public BinaryTypeHelper(String type){
		this.type=type;
	}
	
	@Override
	public void addQuestionInfo(Question question, Row row) {
		// TODO Auto-generated method stub
		
	}

}
