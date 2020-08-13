package com.ram.microservice.forum.datalayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ram.microservice.forum.entities.QuestionBank;

@Repository
@Transactional
public class QuestionBankDao {

	/*@Autowired
    private SessionFactory sessionFactory;*/
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public void setQuestionBank(QuestionBank qBank)
    {
    	//sessionFactory.getCurrentSession().saveOrUpdate(qBank);
    } 
	

}
