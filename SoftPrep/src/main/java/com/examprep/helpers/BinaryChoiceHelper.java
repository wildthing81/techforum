package com.examprep.helpers;

import com.examprep.entities.BinaryChoiceQuestion;
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
		 BinaryChoiceQuestion question=new BinaryChoiceQuestion(qBankID,type);
		 question.setQuestion(row.getCell(1).getStringCellValue());
		 question.setAnswer(Boolean.parseBoolean(row.getCell(2).getStringCellValue()));
		
		 return question;
	}

}
