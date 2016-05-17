package com.examprep.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.examprep.services.LookUpService;

@RestController(value="lookup")
public class LookUpController {
	
	@Autowired
	private LookUpService lookUpService;
	
	@RequestMapping(value="getstreams.htm")
	public Map<Integer, String> getStreams()
	{
		//return lookUpService.getStreams();
		
		Map<Integer, String> streamMap = new HashMap<Integer, String>();
		streamMap.put(1, "stream1");
		streamMap.put(1, "stream2");
		return streamMap;
		
	}
	
	@RequestMapping(value="/questioncount.htm")
	public List<Integer> getQuestionCount()
	{
		//return lookUpService.getQuestionCount();
		List<Integer> questionCountList = new ArrayList<Integer>();
		questionCountList.add(10);
		questionCountList.add(20);
		questionCountList.add(25);
		return questionCountList;
	}
	
	@RequestMapping(value="/examduration.htm")
	public List<Long> getExamDuration()
	{
		//return lookUpService.getExamDuration();
		List<Long> examDurList = new ArrayList<Long>();
		examDurList.add((long) (25));
		examDurList.add((long) (35));
		examDurList.add((long) (45));
		return examDurList;
		
	}
}
