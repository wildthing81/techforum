package com.examprep.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * @author asus
 *
 */
@Entity
@Table(name="EP_USER")
public class EPUser {
        
        @Id 
        @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="useridgenerator")
        @SequenceGenerator(name="useridgenerator",sequenceName="USERID_SEQ",allocationSize=1)
        @Column(name="user_id")
	private long userID;
        
        @Column(name="user_name")
	private String userName;
        
        @Column(name="first_name")
	private String firstName;
        
        @Column(name="last_name")
	private String lastName;
        
        @Column(name="is_admin")
	private boolean isAdmin;
        
        @Column(name="is_locked")
	private Boolean isLocked;
        
        @Column(name="password")
	private String password;
        
        @Column(name="email_id")
	private String emailId;
        
        @Column(name="role")
	private Integer role;
	
	public EPUser(String userName,String firstName,String lastName,String password
				,boolean isAdmin,Integer role){
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

	public Boolean getIsLocked() {
		return isLocked;
	}

	public void setIsLocked(Boolean isLocked) {
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

	public Integer getRole() {
		// TODO Auto-generated method stub
		return this.role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	
}
