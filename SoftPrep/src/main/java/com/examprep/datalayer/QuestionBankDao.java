package com.examprep.datalayer;

import java.util.List;

import com.examprep.entities.QuestionBank;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.examprep.entities.Question;

@Repository
@Transactional
public class QuestionBankDao {

	@Autowired
    private SessionFactory sessionFactory;
    
	public void setQuestionBank(QuestionBank qBank)
    {
    	sessionFactory.getCurrentSession().saveOrUpdate(qBank);
    } 
	
	
	public Question getQuestion(long qBankID, int qNum) {
		Session session=sessionFactory.getCurrentSession();
		String hql = "from Question q where q.qBankID=:qBankID";
		Query query = session.createQuery(hql);
		query.setParameter("qBankID", qBankID);
		List questions=query.list();
		return  (Question) questions.get(qNum);
		
	}
	
	public void setQuestion(Question question){
		sessionFactory.getCurrentSession().saveOrUpdate(question);
	}
	
	public Question getQuestion(long questionId){
		return (Question)sessionFactory.getCurrentSession()
							.get(Question.class,new Long(questionId));
	}
}
