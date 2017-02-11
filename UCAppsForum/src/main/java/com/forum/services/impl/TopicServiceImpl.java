/**
 * 
 */
package com.examprep.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examprep.datalayer.StreamDao;
import com.examprep.entities.Stream;
import com.examprep.services.StreamService;

/**
 * @author asus
 *
 */
@Service
public class TopicServiceImpl implements TopicService{

	@Autowired
	public StreamDao streamDao;
	
	@Override
	public Stream getTopic(int streamId) {
		return streamDao.getStream(streamId);
		
	}

	
}
