/**
 * 
 */
package com.forum.services;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.forum.datalayer.QuestionDao;
import com.forum.entities.Answer;
import com.forum.entities.Question;
import com.forum.entities.dto.QuestionDto;
import com.forum.services.impl.QuestionServiceImpl;


/**
 * @author r79
 *
 */
//@ContextConfiguration(locations = {"classpath:/application-context.xml"})
//@ContextConfiguration(classes = {"classpath:/application-context.xml"})
//@RunWith(SpringJUnit4ClassRunner.class)
public class TestQuestionService {

	/**
	 * @throws java.lang.Exception
	 */
	@Mock
	private QuestionDao questionDao;
	
	@InjectMocks
	QuestionServiceImpl questionService;
	
	QuestionDto questiondto;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		questiondto=new QuestionDto();
		questiondto.setQuestion("What does SAAS stands for");
		questiondto.setqBankID(10);
		
	}

	
	/**
	 * Test method for {@link com.forum.services.impl.QuestionServiceImpl#addQuestion(com.forum.entities.dto.QuestionDto)}.
	 */
	@Test
	public void testAddQuestion() {
		doNothing().when(questionDao).addQuestion(any(Question.class));
		questionService.addQuestion(questiondto);
		verify(questionDao).addQuestion(any(Question.class));
		
	}

	/**
	 * Test method for {@link com.forum.services.impl.QuestionServiceImpl#getAllQuestions()}.
	 */
	@Test
	public void testGetAllQuestions() {
		List<Question> expresult=new ArrayList<Question>();
		when(questionDao.getAllQuestions()).thenReturn(expresult);
		List<Question> actresult=questionService.getAllQuestions();
		Assert.assertEquals(expresult, actresult);
		verify(questionDao).getAllQuestions();
	}

	/**
	 * Test method for {@link com.forum.services.impl.QuestionServiceImpl#getQuestionsPerUser(long)}.
	 */
	@Test
	public void testGetQuestionsPerUser() {
		List<Question> expresult=new ArrayList<Question>();
		String userId=new String("rama354");
		when(questionDao.getQuestionsPerUser(userId)).
											thenReturn(expresult);
		List<Question> actresult=questionService.getQuestionsPerUser(userId);
		Assert.assertEquals(expresult, actresult);
		verify(questionDao).getQuestionsPerUser(userId);
	}

	/**
	 * Test method for {@link com.forum.services.impl.QuestionServiceImpl#getQuestionsPerTopic(long)}.
	 */
	@Test
	public void testGetQuestionsPerTopic() {
		List<Question> expresult=new ArrayList<Question>();
		long topicId=10;
		when(questionDao.getQuestionsPerTopic(topicId)).
											thenReturn(expresult);
		List<Question> actresult=questionService.getQuestionsPerTopic(topicId);
		Assert.assertEquals(expresult, actresult);
		verify(questionDao).getQuestionsPerTopic(topicId);
	}

	/**
	 * Test method for {@link com.forum.services.impl.QuestionServiceImpl#getQuestion(java.lang.String)}.
	 */
	@Test
	public void testGetQuestion() {
		Question expresult=new Question();
		String questionId="10";
		when(questionDao.getQuestion(questionId)).
											thenReturn(expresult);
		Question actresult=questionService.getQuestion(questionId);
		Assert.assertEquals(expresult, actresult);
		verify(questionDao).getQuestion(questionId);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
}
