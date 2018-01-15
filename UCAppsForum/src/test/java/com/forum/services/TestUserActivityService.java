package com.forum.services;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.forum.datalayer.UserActivityDao;

public class TestUserActivityService {
	
	@Mock
	private UserActivityDao userActivityDao;

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
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateLoginActivity() {
		fail("Not yet implemented");
	}

}
