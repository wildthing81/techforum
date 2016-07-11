package com.examprep.datalayer;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.examprep.entities.BinaryChoiceQuestion;
import com.examprep.entities.FillBlanksQuestion;
import com.examprep.entities.MultiChoiceQuestion;
import com.examprep.entities.Question;
import com.examprep.entities.QuestionBank;
import com.examprep.utils.EPConstants;

@Repository
@Transactional
public class QuestionBankDao {

	@Autowired
    private SessionFactory sessionFactory;
    
	@Autowired
	private MongoTemplate mongoTemplate;
	
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
		Question question=(Question) questions.get(qNum);
		return getActualQuestion(question);
		
	}
	
	private Question getActualQuestion(Question question) {
		if (question.getQuestionType().equalsIgnoreCase(EPConstants.MULTI_CHOICE))
			return mongoTemplate.findById(question.getQuestionID(), MultiChoiceQuestion.class);
			
		if (question.getQuestionType().equalsIgnoreCase(EPConstants.BINARY_CHOICE))
			return mongoTemplate.findById(question.getQuestionID(), BinaryChoiceQuestion.class);
		
		if (question.getQuestionType().equalsIgnoreCase(EPConstants.FILL_BLANKS))
			return mongoTemplate.findById(question.getQuestionID(), FillBlanksQuestion.class);
		
		return null;
	}


	public void setQuestion(Question question){
		sessionFactory.getCurrentSession().saveOrUpdate(question);
	}
	
	public Question getQuestion(long questionId){
		return (Question)sessionFactory.getCurrentSession()
							.get(Question.class,new Long(questionId));
	}
}
