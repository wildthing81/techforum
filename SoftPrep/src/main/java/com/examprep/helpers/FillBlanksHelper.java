package com.examprep.helpers;

import java.util.ArrayList;
import java.util.List;

import com.examprep.entities.FillBlanksQuestion;
import com.examprep.entities.Question;
import com.examprep.interfaces.QuestionTypeHelper;
import org.apache.poi.ss.usermodel.Row;

public class FillBlanksHelper implements QuestionTypeHelper {

	private String type;

	public FillBlanksHelper(String type){
		this.type=type;
	}
	
	@Override
	public Question createQuestion(long qBankID, Row row)
	{
		FillBlanksQuestion question=new FillBlanksQuestion(qBankID,type);
		question.setQuestion(row.getCell(1).getStringCellValue());
		List<String> blanks=new ArrayList<String>();
		
		for(short i=2;i<row.getLastCellNum()-1;i++)
			blanks.add(row.getCell(i).getStringCellValue());
		
		question.setAnswer(blanks);
		
		return question;
	}

}
