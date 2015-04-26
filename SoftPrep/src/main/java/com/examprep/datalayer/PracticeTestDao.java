package com.examprep.datalayer;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.examprep.entities.PracticeTest;
import com.examprep.entities.Stream;

@Repository
@Transactional
public class PracticeTestDao {

	
	@Autowired
    private SessionFactory sessionFactory;
    
	
	public long setPracticeTest(PracticeTest test)
    {
    	sessionFactory.getCurrentSession().saveOrUpdate(test);
    	return test.getTestID();
    } 
	
	public PracticeTest getPracticeTest(long testId)
	{
		return (PracticeTest)sessionFactory.getCurrentSession().get(PracticeTest.class, new Long(testId) );
	}
}
