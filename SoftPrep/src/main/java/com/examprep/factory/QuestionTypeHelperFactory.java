package com.examprep.factory;

import com.examprep.helpers.BinaryChoiceHelper;
import com.examprep.helpers.FillBlanksHelper;
import com.examprep.helpers.MultiChoiceHelper;
import com.examprep.interfaces.QuestionTypeHelper;

public class QuestionTypeHelperFactory {
	
	private static QuestionTypeHelperFactory instance;
	
	private QuestionTypeHelperFactory(){
		
	}

	public static QuestionTypeHelperFactory getInstance()
	{
		if (instance==null)
		{
			synchronized(QuestionTypeHelperFactory.class)
			{
				if (instance==null)
					 instance = new QuestionTypeHelperFactory();

			}
			
		}
		
		return instance;
	}
	
	public QuestionTypeHelper createTypeHelper(String type)
	{
		if (type.equalsIgnoreCase(QuestionTypeHelper.TYPE_BINARY))
			return new BinaryChoiceHelper(type);
		
		if (type.equalsIgnoreCase(QuestionTypeHelper.TYPE_MULTI))
			return new MultiChoiceHelper(type);
		
		if (type.equalsIgnoreCase(QuestionTypeHelper.TYPE_FILLBLANKS))
			return new FillBlanksHelper(type);
		
		return null;
	}
}
