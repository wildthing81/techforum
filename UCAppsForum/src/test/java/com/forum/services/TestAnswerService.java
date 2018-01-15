package com.forum.services;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.forum.datalayer.AnswerDao;
import com.forum.entities.Answer;

public class TestAnswerService {

	@Mock
	private AnswerDao answerDao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testAddAnswer() {
		Answer answer=new Answer();
		answer.setAnswer("SAAS stands for Software As a Service");
		answer.setQuestionId("1");
		answer.setUserName("rama354");
		
		//when(answerDao.addAnswer(answer)).thenReturn(1);
	}

	@Test
	public void testGetAllAnswersForQuestion() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAnswersPerUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAnswersPerTopic() {
		fail("Not yet implemented");
	}

}
