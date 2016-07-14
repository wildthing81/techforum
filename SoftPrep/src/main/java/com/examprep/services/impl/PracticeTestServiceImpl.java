package com.examprep.services.impl;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examprep.entities.Question;
import com.examprep.entities.QuestionBank;
import com.examprep.entities.Stream;
import com.examprep.services.QuestionBankService;
import com.examprep.services.QuestionService;
import com.examprep.services.StreamService;
import com.examprep.services.TestService;

@Service
public class PracticeTestServiceImpl implements TestService{

	@Autowired
	private QuestionBankService qBankService;
	
	@Autowired
	private StreamService streamService;
	
	@Autowired
	private QuestionService questionService;
	
	@Override	
	public Question getFirstQuestion(int streamId) {
		List<QuestionBank> qBanks=qBankService.
									getQuestionBanksForStream(streamService.getStream(streamId));

		QuestionBank randomQBank=qBanks.get(new Random().nextInt(qBanks.size()));
		return questionService.getQuestion(randomQBank);
		
	}

}
