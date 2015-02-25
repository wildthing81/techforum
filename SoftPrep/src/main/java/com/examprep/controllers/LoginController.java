package com.examprep.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {

	
	
	@RequestMapping(value="/dashboard.htm",method=RequestMethod.POST)
	public String login(@RequestParam("username") String username,
						@RequestParam("password") String password,Model model)
	{
		
		return "dashboard";
	}
	
	
	/*@RequestMapping(value="/login.htm")
    public String login(HttpServletRequest request, Model model){
        return "login";
    }*/
	
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
