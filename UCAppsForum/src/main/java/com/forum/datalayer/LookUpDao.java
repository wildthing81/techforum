package com.forum.datalayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LookUpDao {

	/*@Autowired
	private SessionFactory sessionFactory;*/
	@Autowired
	private MongoTemplate mongoTemplate;

	/*public Map<Integer, String> getTopics() {
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
	}*/

}
