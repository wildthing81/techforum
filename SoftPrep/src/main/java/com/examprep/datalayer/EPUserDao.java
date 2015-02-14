package com.examprep.datalayer;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.examprep.entities.EPUser;
import com.examprep.exceptions.EPException;


@Repository
@Transactional
public class EPUserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public EPUser findUserByName(String userName)
	{
		Session session= sessionFactory.getCurrentSession();
		Criteria criteria=session.createCriteria(EPUser.class);
		criteria.add(Restrictions.eq("user_name", userName));
		return (EPUser) criteria.uniqueResult();
	}

	public  EPUser getEPUser(final long userID)
    {
    	return (EPUser)sessionFactory.getCurrentSession().get(EPUser.class, new Long(userID));
    }
	
	public void setEPUser(EPUser epuser)
    {
    	sessionFactory.getCurrentSession().saveOrUpdate(epuser);
    }
}
