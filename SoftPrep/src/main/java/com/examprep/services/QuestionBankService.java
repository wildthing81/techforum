package com.examprep.services;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.examprep.entities.QuestionBank;
import com.examprep.entities.Stream;

import com.examprep.factory.QuestionTypeHelperFactory;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.examprep.datalayer.QuestionBankDao;
import com.examprep.datalayer.QuestionDao;
import com.examprep.entities.Question;
import com.examprep.interfaces.QuestionTypeHelper;


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

	private Set<Question> createQuestionBank(InputStream inputStream, long qBankID) 
	{
		//Set<Question> validQuestions=new LinkedHashSet<Question>();
		Set<Question> invalidQuestions=new LinkedHashSet<Question>();
		
		Workbook wb=null;
		try {
			wb=WorkbookFactory.create(inputStream);
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (InvalidFormatException e) 
		{
			
			e.printStackTrace();
		}
			Sheet sheet = wb.getSheetAt(0);
			Iterator<Row> rowIteration = sheet.rowIterator();
			
			while (rowIteration.hasNext())
			{
			     Row row = (Row)rowIteration.next();
				 if (row != null)
				 {
					String type=row.getCell(0).getStringCellValue();	
					QuestionTypeHelper questionTypeHelper=QuestionTypeHelperFactory
																	.getInstance().createTypeHelper(type);
					
					Question question=null;
					if (questionTypeHelper!=null)
					{
						question=questionTypeHelper.createQuestion(qBankID,row);
						if (question!=null)
							questionDao.setQuestion(question);
						else
						{
							invalidQuestions.add(question);
						}
					    
					}
					else
					{
						invalidQuestions.add(question);
					}
									    
				 }
			}
			return invalidQuestions;
		}
	
	    public List<QuestionBank> getQuestionBanksForStream(Stream stream){
			
	    	//List<Question>
	    	
	    	
	    	return null;
	    	
	    }
}
