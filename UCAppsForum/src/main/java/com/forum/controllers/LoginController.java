package com.forum.controllers;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;

import com.forum.entities.UCFUserSession;
import com.forum.utils.UCFConstants;


@Controller
public class LoginController {

	@Autowired
	private UCFUserSession userSession;
	
	/*@Bean
	@Scope("session")
	public UCFUserSession createUserSession(HttpServletRequest req){
		
		UCFUserSession userSession=new UCFUserSession();
		userSession.setLoginTime(new Date());
		userSession.setUserName(userDetails.getUsername());
	}*/
	
	@RequestMapping("/login.htm")
	public String login(Model model)
	{
		return "login";
	}
	
	@RequestMapping("/homepage.htm")
	public String dashboard(Model model,HttpSession session)
	{
		System.out.println("login with "+userSession.getUserName()+" was successful");
		model.addAttribute("loginTime",userSession.getLoginTime());
		model.addAttribute("user", userSession.getUserName());
		return "homepage";
	}
	
	@RequestMapping("/error.htm")
	public String failurePage(Model model)
	{
		System.out.println("LoginController:error");
		return "error";
	}
	
		
	@RequestMapping("/403")
	public String accesssDenied(Model model) 
	{
 
	  //check if user is login
	  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	  if (!(auth instanceof AnonymousAuthenticationToken)) 
	  {
		UserDetails userDetail = (UserDetails) auth.getPrincipal();	
		model.addAttribute("username", userDetail.getUsername());
	  }
 
	  return "403";
 
	}
}
