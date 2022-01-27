/**
 * 
 */
package com.crs.flipkart.bean;

/**
 * @author harsh
 *
 */
public class Student extends User {
	private String branch;
	private boolean isApproved;
	private boolean isRegistered;
	private boolean isReportApproved;
	
	public Student(String id, String password) {
		super(id, password, 1);
		// TODO Auto-generated constructor stub
	}

	public Student(String id) {
		// TODO Auto-generated constructor stub
		super(id);
	}

	
	public Student() {
		super();
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public boolean isApproved() {
		return isApproved;
	}

	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}

	public boolean isRegistered() {
		return isRegistered;
	}

	public void setRegistered(boolean isRegistered) {
		this.isRegistered = isRegistered;
	}

	public boolean isReportApproved() {
		return isReportApproved;
	}

	public void setReportApproved(boolean isReportApproved) {
		this.isReportApproved = isReportApproved;
	}


}
