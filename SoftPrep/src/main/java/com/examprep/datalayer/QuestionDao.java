package com.examprep.datalayer;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.examprep.entities.Question;


@Repository
public class QuestionDao {

	@Autowired
    private SessionFactory sessionFactory;
	
	

}
