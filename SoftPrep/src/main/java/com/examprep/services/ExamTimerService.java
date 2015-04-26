package com.examprep.services;

import java.util.Timer;
import java.util.TimerTask;

import org.springframework.stereotype.Service;


@Service
public class ExamTimerService extends Timer {
    
   
	public void startTimer(long duration){
		scheduleAtFixedRate(new ExamClock(duration),0, 2000);
		
	}
	
	class ExamClock extends TimerTask{

		private long duration;
		
		public ExamClock(long duration){
			this.duration=duration;
		}
		
		@Override
		public void run() 
		{
		   duration-=2000;
		   if (duration==0)
			   System.out.println("You still have "+duration/1000+" secs left");
		   else
			   System.out.println("Your Time is Up");
		}
		
		
	}
	
}
