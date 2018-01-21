package com.forum.services;

import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.forum.datalayer.AnswerDao;
import com.forum.entities.Answer;
import com.forum.entities.Question;
import com.forum.entities.dto.AnswerDto;
import com.forum.services.impl.AnswerServiceImpl;
import com.forum.services.impl.QuestionServiceImpl;

@ContextConfiguration(classes = {"classpath:/application-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestAnswerService {

	@Mock
	private AnswerDao answerDao;
	
	@InjectMocks
	AnswerServiceImpl answerService;
	
	AnswerDto answer;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		answer=new AnswerDto();
		answer.setAnswer("SAAS stands for Software As a Service");
		answer.setQuestionId("1");
	}
	
	@Test
	public void testAddAnswer() {
		doNothing().when(answerDao).addAnswer(any(Answer.class));
		answerService.addAnswer(answer, "rama354");
		verify(answerDao).addAnswer(any(Answer.class));
		
	}

	@Test
	public void testGetAllAnswersForQuestion() {
		//fail("Not yet implemented");
	}

	@Test
	public void testGetAnswersPerUser() {
		//fail("Not yet implemented");
	}

	@Test
	public void testGetAnswersPerTopic() {
		//fail("Not yet implemented");
	}

}
