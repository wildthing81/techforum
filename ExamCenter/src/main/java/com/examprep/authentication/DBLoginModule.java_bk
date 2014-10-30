/**
 * 
 */
package com.authentication;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.SessionFactoryImpl;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.spi.ServiceRegistryImplementor;

import com.authentication.PageLoginCallBackHandler;

/**
 * @author asus
 *
 */
public class DBLoginModule implements LoginModule {

	private CallbackHandler cbh = null;
	private Subject subject=null;
	private SessionFactory dbSessionFactory=null;
	private boolean isLoginSuccess=false;
	//private boolean isCommitSuccess=false;
	
	@Override
	public boolean abort() throws LoginException 
	{
		if (cbh instanceof PageLoginCallBackHandler)
		{
			((PageLoginCallBackHandler)cbh).setPassword(null);
			((PageLoginCallBackHandler)cbh).setUsername(null);
		}
	
		return true;	
	}

	@Override
	public boolean commit() throws LoginException 
	{
		if(isLoginSuccess){
			subject.getPrincipals().add(new LDAPrincipal());
			return true;
		}
		else{
			subject.getPrincipals().add(new ErrorPrincipal());
			return false;
		}
		//isCommitSuccess=true;		
	}

	@Override
	public void initialize(Subject arg0, CallbackHandler arg1,
			Map<String, ?> arg2, Map<String, ?> arg3) {
		// TODO Auto-generated method stub
		cbh = arg1;
		this.subject=arg0;
		dbSessionFactory=createDBSessionFactory();
	}

	@Override
	public boolean login() throws LoginException
	{	

		Callback[] callbacks = new Callback[2];
		callbacks[0] = new NameCallback("username");
		callbacks[1] = new PasswordCallback("password",false);
		try {
			cbh.handle(callbacks);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedCallbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String cbh_password=String.valueOf(((PasswordCallback)callbacks[1]).getPassword());
		String cbh_username=((NameCallback)callbacks[0]).getName();
		
		//System.out.println("(PasswordCallback)callbacks[1]).getPassword() "+cbh_password);
		Session session=dbSessionFactory.openSession();
		String hql="FROM User U where U.username=:username and U.password=:password";
		Query query=session.createQuery(hql);
		query.setParameter("username", cbh_username);
		query.setParameter("password", cbh_password);
		
		List<?> result=query.list();
		if (result.size()!=0){
			isLoginSuccess=true;
			return true;
		}
		else
			return false;	
		///Subject with unique ID ?????
		
	}

	private SessionFactory createDBSessionFactory() 
	{
		Configuration configuration=new Configuration();
		configuration.configure();
		ServiceRegistry registry=new StandardServiceRegistryBuilder()
											.applySettings(configuration.getProperties()).build();
		
		return configuration.buildSessionFactory(registry);
		 
		
	}

	@Override
	public boolean logout() throws LoginException {
		subject=null;
		return false;
	}

	
	
}
