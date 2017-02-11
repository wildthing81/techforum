/**
 * 
 */
package com.examprep.services.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examprep.datalayer.LookUpDao;
import com.examprep.services.LookUpService;

/**
 * @author asus
 *
 */
@Service
public class LookUpServiceImpl implements LookUpService {

	@Autowired
	private LookUpDao lookUpDAO;
	
	@Override
	public Map<Integer, String> getTopics() {
		return lookUpDAO.getTopics();
		
		
	}

	@Override
	public List<Integer> getQuestions() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
