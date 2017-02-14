package com.forum.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.forum.services.QuestionService;


@Controller
public class LoginController {

	
	@RequestMapping(value="/login.htm")
	public String login(Model model)
	{
		return "login";
	}
	
	@RequestMapping(value="/homepage.htm")
	public String dashboard(Model model)
	{
		UserDetails userDetails = null;
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken))
		        userDetails = (UserDetails) auth.getPrincipal();
		
		System.out.println("login with "+userDetails.getUsername()+" was successful");
		model.addAttribute("user", userDetails.getUsername());
		
		return "homepage";
	}
	
	@RequestMapping(value="/error.htm")
	public String failurePage(Model model)
	{
		System.out.println("LoginController:error");
		return "error";
	}
	
		
	@RequestMapping(value = "/403", method = RequestMethod.GET)
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
