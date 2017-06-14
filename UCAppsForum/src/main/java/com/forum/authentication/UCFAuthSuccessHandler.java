package com.forum.authentication;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.forum.entities.UCFUserSession;
import com.forum.services.UserActivityService;

@Component
public class UCFAuthSuccessHandler implements AuthenticationSuccessHandler {
	
	@Autowired
    private UserActivityService userActivityService;
	
	@Autowired
	private UCFUserSession userSession;
	
	private static final SimpleGrantedAuthority ADMIN_AUTHORITY = new SimpleGrantedAuthority("ROLE_ADMIN");
	private static final String USER_SESSION="user_session";
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse res, 
										Authentication auth) throws IOException, ServletException 
	{
		UserDetails userDetails = null;
		if ( auth!=null && !(auth instanceof AnonymousAuthenticationToken))
	        	userDetails = (UserDetails) auth.getPrincipal();
		
		userSession.setLoginTime(new Date());
		userSession.setUserName(userDetails.getUsername());
		
		userActivityService.updateLoginActivity(userSession.getLoginTime(),userDetails.getUsername());
        HttpSession session=req.getSession(false);
        session.setAttribute(USER_SESSION, userSession);
        
		Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
        if (authorities.contains(ADMIN_AUTHORITY)) {
            redirectStrategy.sendRedirect(req, res, "/admin.htm");
        } else {
            redirectStrategy.sendRedirect(req, res, "/homepage.htm");
        }

	}

}
