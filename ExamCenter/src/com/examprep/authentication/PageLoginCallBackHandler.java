package com.authentication;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;

/**
 * @author kartik
 *
 */
public class PageLoginCallBackHandler implements CallbackHandler {

	/* (non-Javadoc)
	 * @see javax.security.auth.callback.CallbackHandler#handle(javax.security.auth.callback.Callback[])
	 */
	private String username=null;
	private String password=null;
		
	public PageLoginCallBackHandler()
	{
		//this.username=username;
		//this.password=password;
	}
	public PageLoginCallBackHandler(String username,String password){
		this.username=username;
	    this.password=password;
	}
	
	@Override
	public void handle(Callback[] callbacks) throws IOException,
			UnsupportedCallbackException 
	{
		for(int i=0;i<callbacks.length;i++)
		{
			if (callbacks[i] instanceof NameCallback){
			   ((NameCallback)callbacks[i]).setName(username);
			}
			else if (callbacks[i] instanceof PasswordCallback)
			{
				System.out.println(password);
				((PasswordCallback)callbacks[i]).setPassword(password.toCharArray());			
			}else 
			{
				throw new UnsupportedCallbackException(callbacks[i], "The submitted Callback is unsupported");
			}
			
		}

	}
	/**
	 * @param username the username to set
	 */
	public final void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @param password the password to set
	 */
	public final void setPassword(String password) {
		this.password = password;
	}

}
