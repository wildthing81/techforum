package com.examprep.helpers;

import java.util.ArrayList;
import java.util.List;

import com.examprep.entities.MultiChoiceQuestion;
import com.examprep.entities.Question;
import com.examprep.interfaces.QuestionTypeHelper;
import org.apache.poi.ss.usermodel.Row;

public class MultiChoiceHelper implements QuestionTypeHelper {

	private String type;

	public MultiChoiceHelper(String type){
		this.type=type;
	}
	
	@Override
	public Question createQuestion(long qBankID, Row row) 
	{
		MultiChoiceQuestion question=new MultiChoiceQuestion(qBankID);
		question.setQuestion(row.getCell(1).getStringCellValue());
		List<String> choices=new ArrayList<String>();
		
		for(short i=2;i<row.getLastCellNum()-1;i++)
			choices.add(row.getCell(i).getStringCellValue());
		
		question.setChoices(choices);
		question.setAnswer(row.getCell(row.getLastCellNum()-1).getStringCellValue());
		
		return question;
	}

}