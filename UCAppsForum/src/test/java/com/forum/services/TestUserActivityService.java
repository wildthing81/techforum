package com.forum.services;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.Date;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.forum.datalayer.UserActivityDao;
import com.forum.entities.Question;
import com.forum.entities.UCFUserActivity;
import com.forum.services.impl.UserActivityServiceImpl;

//@ContextConfiguration(classes = {"classpath:/application-context.xml"})
//@RunWith(SpringJUnit4ClassRunner.class)
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
		loginActivity=new UCFUserActivity();
		
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testUserActivityFeed() {
		
	}

	@Test
	public void testUpdateAndGetLoginActivity() {
		doNothing().when(userActivityDao).updateLoginActivity(loginActivity);
		Date loginTime = new Date(System.currentTimeMillis());
		activityService.updateLoginActivity(loginTime, "rama354");
		Assert.assertNotEquals(loginTime, loginActivity.getActivityTime());
		verify(userActivityDao).updateLoginActivity(any(UCFUserActivity.class));
		
		when(userActivityDao.getCurrentLoginActivity(any(String.class))).thenReturn(loginActivity);
		UCFUserActivity actual=activityService.getCurrentLoginActivity("rama354");
		Assert.assertEquals(loginActivity, actual);
		verify(userActivityDao).getCurrentLoginActivity("rama354");
	}
	
	@Test
	public void testGetCurrentLoginActivity(){
		
	}
}
