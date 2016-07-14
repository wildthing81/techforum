package com.examprep.datalayer;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.examprep.entities.QuestionBank;

@Repository
@Transactional
public class QuestionBankDao {

	@Autowired
    private SessionFactory sessionFactory;
    
	
	public void setQuestionBank(QuestionBank qBank)
    {
    	sessionFactory.getCurrentSession().saveOrUpdate(qBank);
    } 
	

}
