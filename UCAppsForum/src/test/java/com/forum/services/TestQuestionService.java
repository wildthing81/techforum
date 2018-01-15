/**
 * 
 */
package com.forum.services;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

import com.forum.datalayer.QuestionDao;
import com.forum.entities.Question;


/**
 * @author r79
 *
 */
public class TestQuestionService {

	/**
	 * @throws java.lang.Exception
	 */
	@Mock
	private QuestionDao questionDao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	
	/**
	 * Test method for {@link com.forum.services.impl.QuestionServiceImpl#addQuestion(com.forum.entities.dto.QuestionDto)}.
	 */
	@Test
	public void testAddQuestion() {
		
		Question question=new Question();
		question.setQuestion("What does SAAS stands for");
		question.setqBankID(10);
		
		//when(questionDao.addQuestion(question)).thenReturn(1);
		
		
	}

	/**
	 * Test method for {@link com.forum.services.impl.QuestionServiceImpl#getAllQuestions()}.
	 */
	@Test
	public void testGetAllQuestions() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.forum.services.impl.QuestionServiceImpl#getQuestionsPerUser(long)}.
	 */
	@Test
	public void testGetQuestionsPerUser() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.forum.services.impl.QuestionServiceImpl#getQuestionsPerTopic(long)}.
	 */
	@Test
	public void testGetQuestionsPerTopic() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.forum.services.impl.QuestionServiceImpl#getQuestion(java.lang.String)}.
	 */
	@Test
	public void testGetQuestion() {
		fail("Not yet implemented");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
}
