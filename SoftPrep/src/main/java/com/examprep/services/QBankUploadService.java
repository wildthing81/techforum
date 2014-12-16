package com.examprep;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.WorkbookUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.examprep.entities.Question;


@Service
public class QBankUploadService {

	
	public String uploadQuestionBank(String name,MultipartFile file){
		System.out.println("question bank name: "+name);
		createQuestionBank(file.getInputStream());
		
	}

	private void createQuestionBank(InputStream inputStream) 
	{
		Set<Question> questions=new LinkedHashSet<Question>();
		Workbook wb=null;
		try {
			wb=new HSSFWorkbook();
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (InvalidFormatException e) 
		{
			
			e.printStackTrace();
		}
			Sheet sheet = wb.getSheetAt(0);
			boolean isAll = (empname.length()==0)?true:false;
			//if (!isAll)
			Iterator<Row> rowIteration = sheet.rowIterator();
			boolean isEmpRowIdentified=false;    // If an employee name is sent in the Form
			
			while (rowIteration.hasNext() && !isEmpRowIdentified)
			{
			     Row row = (Row)rowIteration.next();
				 if (row != null)
				 {
				    if (!isAll)
				    {
				    	Iterator<Cell> cellIteration = row.cellIterator();
				    	while (cellIteration.hasNext())
				    	{
				    		Cell cell= (Cell)cellIteration.next();
				    		if (cell != null)
				    		{
				    			isEmpRowIdentified=identifyRow(cell,empname);
				    		    break;
				    		}
				    	}
				    	if (isEmpRowIdentified)
				    		workBookRows.add(createEntity(row));
				    }
				    else
				    {
				    	workBookRows.add(createEntity(row));
				    }
				 }
			}
			return workBookRows;
		}
}
