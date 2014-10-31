/**
 * 
 */
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

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	/**
	 * @return the userID
	 */
	public long getUserID() {
		return userID;
	}

	
}
