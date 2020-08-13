package com.ram.microservice.forum.services;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ram.microservice.forum.datalayer.QuestionBankDao;
import com.ram.microservice.forum.datalayer.QuestionDao;
import com.ram.microservice.forum.entities.Question;
import com.ram.microservice.forum.entities.QuestionBank;


@Service
public class QuestionBankService {

	@Autowired
	QuestionBankDao qBankDao;
	
	@Autowired
	QuestionDao questionDao;
	
	public String uploadQuestionBank(String name,MultipartFile file)
	{
		System.out.println("question bank name: "+name);
		QuestionBank qBank = new QuestionBank(name);
		qBankDao.setQuestionBank(qBank);
	
		Set<Question> invalid;
		try 
		{
			invalid = createQuestionBank(file.getInputStream(),qBank.getQBankID());
			if (invalid.size()==0)
				return "upload success";
			else
			{
				return "upload error";
				//+ link listing invalid questions
			}
		} catch (IOException e) 
		{
			e.printStackTrace();
			return "fileaccess error";
		}
		
	}

	private Set<Question> createQuestionBank(InputStream inputStream, long qBankID) {
		Set<Question> invalidQuestions = new LinkedHashSet<Question>();
		Workbook wb = null;
		try {
			wb = WorkbookFactory.create(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Sheet sheet = wb.getSheetAt(0);
		Iterator<Row> rowIteration = sheet.rowIterator();

		while (rowIteration.hasNext()) {
			Row row = (Row) rowIteration.next();
			if (row != null) {
				String type = row.getCell(0).getStringCellValue();
				Question question = createQuestion(qBankID, row);
				if (question != null)
					questionDao.addQuestion(question);
				else
					invalidQuestions.add(question);

			}

		}

		return invalidQuestions;
	}
	
    public Question createQuestion(long qBankID,Row row)
    {
    	Question question=new Question(qBankID);
		question.setQuestion(row.getCell(1).getStringCellValue());
		List<String> choices=new ArrayList<String>();
		
		for(short i=2;i<row.getLastCellNum()-1;i++)
			choices.add(row.getCell(i).getStringCellValue());
		
		
		return question;
    }
}
