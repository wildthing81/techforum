package com.examprep.helpers;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;

import com.examprep.entities.FillBlanksQuestion;
import com.examprep.entities.Question;
import com.examprep.interfaces.QuestionTypeHelper;

public class FillBlanksHelper implements QuestionTypeHelper {

	private String type;

	public FillBlanksHelper(String type){
		this.type=type;
	}
	
	@Override
	public Question createQuestion(long qBankID, Row row)
	{
		FillBlanksQuestion question=new FillBlanksQuestion(qBankID);
		question.setQuestion(row.getCell(1).getStringCellValue());
		question.setAnswer(row.getCell(2).getStringCellValue());
		
		List<String> choices=new ArrayList<String>();
		for(short i=3;i<row.getLastCellNum()-1;i++)
			choices.add(row.getCell(i).getStringCellValue());
		
		question.setChoices(choices);
		
		return question;
	}

}
