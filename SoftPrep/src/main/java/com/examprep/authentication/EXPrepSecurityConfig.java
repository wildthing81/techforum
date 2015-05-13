package com.examprep.authentication;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebMvcSecurity
public class EXPrepSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	DataSource epDataSource;
	
	@Autowired
	@Qualifier("epUser")
    private UserDetailsService userDetailsService;
	
	
	@Override
    protected void configure(AuthenticationManagerBuilder authManagerBuilder) 
    												throws Exception 
    {
         
		authManagerBuilder.userDetailsService(userDetailsService)
													.passwordEncoder(encoder());
		
		/*authManagerBuilder.jdbcAuthentication().dataSource(epDataSource)
                .passwordEncoder(new BCryptPasswordEncoder());*/
         
         	//	.usersByUsernameQuery("select user_name,password from ep_user where user_name=?" +
         	//			"and password=?");
         		//.authoritiesByUsernameQuery("select username, role from user_roles where username=?");
         		
    }
	
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login.htm").failureUrl("/login.htm?error")
                .loginProcessingUrl("/spring_sec_auth.htm")
                .defaultSuccessUrl("/dashboard.htm")
                .usernameParameter("username").passwordParameter("password").permitAll()
                /*.and().logout().logoutSuccessUrl("/login.htm?logout").permitAll()
                .and().exceptionHandling().accessDeniedPage("/403")*/
                .and().csrf().disable();
                
    }
	
	@Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}
