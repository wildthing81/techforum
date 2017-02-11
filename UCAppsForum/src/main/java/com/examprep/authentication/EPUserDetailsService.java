package com.examprep.authentication;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.examprep.authorization.RoleConstants;
import com.examprep.datalayer.EPUserDao;
import com.examprep.entities.EPUser;

@Service("epUser")
public class EPUserDetailsService implements UserDetailsService {

	@Autowired
	private EPUserDao epUserDao;

	@Override
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {

			EPUser epUser = epUserDao.findUserByName(userName);
			boolean enabled = true;
			boolean accountNonExpired = true;
			boolean credentialsNonExpired = true;
			boolean accountNonLocked = true;
			
			/*String encryptpwd= new BCryptPasswordEncoder().encode("l00nie");
			System.out.println(encryptpwd);*/
			
			return new User(epUser.getUserName(), epUser.getPassword()
					.toLowerCase(), enabled, accountNonExpired,
					credentialsNonExpired, accountNonLocked,
					getAuthorities(epUser.getRole()));

		
	}

	/**
	 * Retrieves a collection of {@link GrantedAuthority} based on a numerical
	 * role
	 * 
	 * @param role
	 *            the numerical role
	 * @return a collection of {@link GrantedAuthority
	 */
	public Collection<? extends GrantedAuthority> getAuthorities(Integer role) {
		List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(role));
		return authList;
	}

	/**
	 * Converts a numerical role to an equivalent list of roles
	 * 
	 * @param role
	 *            the numerical role
	 * @return list of roles as as a list of {@link String}
	 */
	public List<String> getRoles(Integer role) {
		List<String> roles = new ArrayList<String>();

		if (role.intValue() == 1) 
			roles.add(RoleConstants.ROLE_ADMIN);

		if (role.intValue() == 2) 
			roles.add(RoleConstants.ROLE_USER);
		

		return roles;
	}

	/**
	 * Wraps {@link String} roles to {@link SimpleGrantedAuthority} objects
	 * 
	 * @param roles
	 *            {@link String} of roles
	 * @return list of granted authorities
	 */
	public static List<GrantedAuthority> getGrantedAuthorities(
			List<String> roles) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (String role : roles) 
		{
			if (role.equals(RoleConstants.ROLE_ADMIN))
				authorities.add(new SimpleGrantedAuthority(role));
		}
		return authorities;
	}

}
