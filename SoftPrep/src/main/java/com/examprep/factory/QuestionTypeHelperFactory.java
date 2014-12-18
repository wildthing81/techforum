package com.examprep.factory;

import com.examprep.helpers.FillBlanksHelper;
import com.examprep.helpers.MultiTypeHelper;
import com.examprep.interfaces.QuestionTypeHelper;
import com.examprep.helpers.BinaryTypeHelper;

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
			return new BinaryTypeHelper(type);
		
		if (type.equalsIgnoreCase(QuestionTypeHelper.TYPE_BINARY))
			return new MultiTypeHelper(type);
		
		if (type.equalsIgnoreCase(QuestionTypeHelper.TYPE_BINARY))
			return new FillBlanksHelper(type);
	}
}
