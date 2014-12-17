package com.examprep;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import com.examprep.entities.QuestionBank;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.WorkbookUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.examprep.datalayer.QuestionBankDao;
import com.examprep.entities.Question;


@Service
public class QBankUploadService {

	@Autowired
	QuestionBankDao qBankDao;
	
	public String uploadQuestionBank(String name,MultipartFile file){
		System.out.println("question bank name: "+name);
		QuestionBank qBank = new QuestionBank(name);
		qBankDao.setQuestionBank(qBank);
		createQuestionBank(file.getInputStream(),qBank.getqBankID());
		
	}

	private Set<Question> createQuestionBank(InputStream inputStream, long qBankID) 
	{
		Set<Question> questions=new LinkedHashSet<Question>();
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
			//boolean isAll = (empname.length()==0)?true:false;
			//if (!isAll)
			Iterator<Row> rowIteration = sheet.rowIterator();
			
			while (rowIteration.hasNext())
			{
			     Row row = (Row)rowIteration.next();
				 if (row != null)
				 {
					Question question=new Question(qBankID);;
					Iterator<Cell> cellIteration = row.cellIterator();
				    while (cellIteration.hasNext())
				    {
				    	Cell cell= (Cell)cellIteration.next();
				    	if (cell != null)
				    	{
				    		//switch case: type of question	
				    		
				    	}
				    	
				    }
				    	qBankDao.setQuestion(question);
				    	questions.add(question);			    
				 }
			}
			return questions;
		}
}
