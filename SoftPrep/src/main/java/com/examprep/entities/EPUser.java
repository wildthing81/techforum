package com.examprep.entities;

/**
 * @author asus
 *
 */
public class EPUser {

	private long userID;
	private String userName;
	private String firstName;
	private String lastName;
	private boolean isAdmin;
	private boolean isLocked;
	private String password;
	private String emailId;
	private int role;
	
	public EPUser(String userName,String firstName,String lastName,String password
				,boolean isAdmin,int role){
		this.userName=userName;
		this.firstName=firstName;
		this.lastName=lastName;
		this.isAdmin=isAdmin;
		this.password=password;
		this.role=role;
	}

	public EPUser(){
		
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

	public boolean getIsLocked() {
		return isLocked;
	}

	public void setIsLocked(boolean isLocked) {
		this.isLocked = isLocked;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public int getRole() {
		// TODO Auto-generated method stub
		return this.role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	
}
