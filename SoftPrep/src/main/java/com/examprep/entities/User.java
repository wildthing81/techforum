package com.examprep.entities;

/**
 * @author asus
 *
 */
public class User {

	private long userID;
	private String userName;
	private String firstName;
	private String lastName;
	private boolean isAdmin;
	
	public User(String userName,String firstName,String lastName,boolean isAdmin){
		this.userName=userName;
		this.firstName=firstName;
		this.lastName=lastName;
		this.isAdmin=isAdmin;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	/**
	 * @return the userID
	 */
	public long getUserID() {
		return userID;
	}

	
}
