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
public class Student extends User {
	private String branch;
	private boolean isApproved;
	private boolean isRegistered;
	private boolean isReportApproved;
	

	/**
	 * Parameterized constructor
	 * @param id
	 * @param password
	 */
	public Student(String id, String password) {
		super(id, password, 1);
		// TODO Auto-generated constructor stub
	}

	/**
	 * parameterized constructor
	 * @param id
	 */
	public Student(String id) {
		// TODO Auto-generated constructor stub
		super(id);
	}

	/**
	 * Default constructor
	 */
	public Student() {
		super();
	}

	
	/**
	 * Method to get branch 
	 * @return String
	 */
	public String getBranch() {
		return branch;
	}

	
	/**
	 * Method to set branch 
	 * @param branch
	 */
	public void setBranch(String branch) {
		this.branch = branch;
	}

	
	/** 
	 * Method to get isApproved status 
	 * @return boolean
	 */
	public boolean isApproved() {
		return isApproved;
	}

	
	/** 
	 * Method to set isApproved status
	 * @param isApproved
	 */
	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}

	
	/** 
	 * Method to get isRegistered status
	 * @return boolean
	 */
	public boolean isRegistered() {
		return isRegistered;
	}

	
	/** 
	 * Method to set isRegistered status
	 * @param isRegistered
	 */
	public void setRegistered(boolean isRegistered) {
		this.isRegistered = isRegistered;
	}

	
	/** 
	 * Method to get isReportApproved
	 * @return boolean
	 */
	public boolean isReportApproved() {
		return isReportApproved;
	}

	
	/** 
	 * Method to set isReportApproved
	 * @param isReportApproved
	 */
	public void setReportApproved(boolean isReportApproved) {
		this.isReportApproved = isReportApproved;
	}


}
