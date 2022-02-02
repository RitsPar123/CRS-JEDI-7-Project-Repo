/**
 * 
 */
package com.crs.flipkart.bean;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author harsh
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {
	private String id;
	private String userName;
	private String password;
	private int role;

	/**
	 * Parameterized constructor
	 * @param id
	 * @param password
	 * @param role
	 */
	public User(String id, String password, int role) {
		this.id = id;
		this.password = password;
		this.role = role;
	}

	/**
	 * Default Constructor
	 */
	public User() {}
	
	/**
	 * Parameterized Constructor 
	 * @param id
	 */
	public User(String id) {
		this.id = id;
	}

	/**
	 * Method to get role of user
	 * @return the role
	 */
	public int getRole() {
		return role;
	}

	/**
	 * Method to set role of user
	 * @param role the role to set
	 */
	public void setRole(int role) {
		this.role = role;
	}

	/**
	 * Method to get UserId
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Method to set UserId
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Method to get UserName
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Method to set UserName
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Method to get Password
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Method to set Password
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
