package com.examprep.interfaces;

import com.examprep.entities.Question;
import org.apache.poi.ss.usermodel.Row;

public interface QuestionTypeHelper {

	public final String TYPE_BINARY="BINARY_CHOICE";
	public final String TYPE_MULTI="MULTI_CHOICE";
	public final String TYPE_FILLBLANK="FILL_BLANKS";
	
	public void addQuestionInfo(Question question,Row row);
}
