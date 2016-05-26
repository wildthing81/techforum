package com.examprep.datalayer;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.examprep.entities.EPUser;
import com.examprep.exceptions.EPException;


@Repository
@Transactional
public class EPUserDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public EPUser findUserByName(String userName)
	{
		Session session=sessionFactory.openSession();
		String hql = "from EPUser ep where ep.userName=:userName";
		Query query = session.createQuery(hql);
		query.setParameter("userName", userName);
		List users=query.list();
		return (EPUser) users.get(0);
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
