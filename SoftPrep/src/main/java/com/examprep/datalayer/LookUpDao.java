package com.examprep.datalayer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LookUpDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Map<Integer, String> getStreams() {
		Map<Integer, String> streamMap = new HashMap<Integer, String>();
		Session session = sessionFactory.getCurrentSession();
		String sql = "select id,streamname from ep_stream";
		Query query = session.createSQLQuery(sql);
		List result = query.list();

		for (Object row : result) {
			Object[] cols = (Object[]) row;
			streamMap.put((Integer) cols[0], (String) cols[1]);
		}

		return streamMap;
	}

	public List<Integer> getQuestionCount() {
		List<Integer> questionCountList = new ArrayList<Integer>();
		Session session = sessionFactory.getCurrentSession();
		String sql = "select id,streamname from ep_stream";
		Query query = session.createSQLQuery(sql);
		List result = query.list();

		for (Object row : result) {
			Object[] cols = (Object[]) row;
			questionCountList.add((Integer) cols[0]);
		}
		return questionCountList;
	}

	public List<Long> getExamDuration() {
		List<Long> examDurList = new ArrayList<Long>();
		Session session = sessionFactory.getCurrentSession();
		String sql = "select id,streamname from ep_stream";
		Query query = session.createSQLQuery(sql);
		List result = query.list();

		for (Object row : result) {
			Object[] cols = (Object[]) row;
			examDurList.add((Long) cols[0]);
		}
		return examDurList;
	}

}
