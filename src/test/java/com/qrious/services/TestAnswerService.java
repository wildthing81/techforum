package com.ram.microservice.forum.services;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.forum.datalayer.AnswerDao;
import com.forum.entities.Answer;
import com.forum.entities.dto.AnswerDto;
import com.forum.services.impl.AnswerServiceImpl;


//@ContextConfiguration(classes = {"classpath:/application-context.xml"})
//@RunWith(SpringJUnit4ClassRunner.class)
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
		List<Answer> expresult=new ArrayList<Answer>();
		String questionId=new String("abc");
		when(answerDao.getAnswersPerQuestion(questionId)).
											thenReturn(expresult);
		List<Answer> actresult=answerService.getAllAnswersForQuestion(questionId);
		Assert.assertEquals(expresult, actresult);
		verify(answerDao).getAnswersPerQuestion(questionId);
	}

	@Test
	public void testGetAnswersPerUser() {
		List<Answer> expresult=new ArrayList<Answer>();
		String userId=new String("rama354");
		when(answerDao.getAnswersPerUser(userId)).
											thenReturn(expresult);
		List<Answer> actresult=answerService.getAnswersPerUser(userId);
		Assert.assertEquals(expresult, actresult);
		verify(answerDao).getAnswersPerUser(userId);
	}

	@Test
	public void testGetAnswersPerTopic() {
		List<Answer> expresult=new ArrayList<Answer>();
		long topicId=10;
		when(answerDao.getAnswersPerTopic(topicId)).
											thenReturn(expresult);
		List<Answer> actresult=answerService.getAnswersPerTopic(topicId);
		Assert.assertEquals(expresult, actresult);
		verify(answerDao).getAnswersPerTopic(topicId);
	}

}
