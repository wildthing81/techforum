/**
 * 
 */
package com.forum.services;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.forum.datalayer.QuestionDao;
import com.forum.entities.Question;
import com.forum.entities.dto.QuestionDto;
import com.forum.services.impl.QuestionServiceImpl;


/**
 * @author r79
 *
 */
//@ContextConfiguration(locations = {"classpath:/application-context.xml"})
@ContextConfiguration(classes = {"classpath:/application-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
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
		//fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.forum.services.impl.QuestionServiceImpl#getQuestionsPerUser(long)}.
	 */
	@Test
	public void testGetQuestionsPerUser() {
		//fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.forum.services.impl.QuestionServiceImpl#getQuestionsPerTopic(long)}.
	 */
	@Test
	public void testGetQuestionsPerTopic() {
		//fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.forum.services.impl.QuestionServiceImpl#getQuestion(java.lang.String)}.
	 */
	@Test
	public void testGetQuestion() {
		//fail("Not yet implemented");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
}
