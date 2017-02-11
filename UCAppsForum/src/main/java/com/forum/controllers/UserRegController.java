package com.forum.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.forum.datalayer.UCFUserDao;
import com.forum.entities.UCFUser;


@Controller
public class UserRegController {
	
	@Autowired
	private UCFUserDao ucfUserDao;
	
	@RequestMapping(value="/userreg.htm")
	public String userRegistration(@ModelAttribute UCFUser ucfUser,Model model)
	{
		ucfUserDao.setUCFUser(ucfUser);
		//logger.info("User Registered Successfully!!!!!!");
		return "Your registration is complete.You will recieve an email shortly containing" +
				"your login credentials.Have a nice day";
	}
	

	@RequestMapping(value="/newsletter.htm")
	public String subscribeLetter(@RequestParam Boolean newsletterFlag,Model model)
	{
		//epUserDao.setEPUser(epUser);
		//logger.info("User Registered Successfully!!!!!!");
		/*return "Your registration is complete.You will recieve an email shortly containing" +
				"your login credentials.Have a nice day";*/
		return null;
	}
	
}
