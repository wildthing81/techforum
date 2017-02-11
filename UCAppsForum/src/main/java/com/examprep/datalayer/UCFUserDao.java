package com.examprep.datalayer;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.examprep.entities.UCFUser;


@Repository
@Transactional
public class UCFUserDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public UCFUser findUserByName(String userName)
	{
		Session session=sessionFactory.openSession();
		String hql = "from EPUser ep where ep.userName=:userName";
		Query query = session.createQuery(hql);
		query.setParameter("userName", userName);
		List users=query.list();
		return (UCFUser) users.get(0);
	}

	public  UCFUser getUCFUser(final long userID)
    {
    	return (UCFUser)sessionFactory.getCurrentSession().get(UCFUser.class, new Long(userID));
    }
	
	public void setUCFUser(UCFUser epuser)
    {
    	sessionFactory.getCurrentSession().saveOrUpdate(epuser);
    }
}
