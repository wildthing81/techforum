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
public class StreamServiceImpl implements StreamService{

	@Autowired
	public StreamDao streamDao;
	
	@Override
	public Stream getStream(int streamId) {
		return streamDao.getStream(streamId);
		
	}

	
}
