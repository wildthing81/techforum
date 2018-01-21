package com.forum.services;

import static org.junit.Assert.*;

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

import com.forum.datalayer.UserActivityDao;
import com.forum.entities.UCFUserActivity;
import com.forum.entities.dto.QuestionDto;
import com.forum.services.impl.QuestionServiceImpl;
import com.forum.services.impl.UserActivityServiceImpl;

@ContextConfiguration(classes = {"classpath:/application-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestUserActivityService {
	
	@Mock
	private UserActivityDao userActivityDao;
	
	@InjectMocks
	UserActivityServiceImpl activityService;
	
	UCFUserActivity loginActivity;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testUserActivityFeed() {
		//fail("Not yet implemented");
	}

	@Test
	public void testUpdateLoginActivity() {
		//fail("Not yet implemented");
	}

}
