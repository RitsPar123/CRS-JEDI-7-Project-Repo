/**
 * 
 */
package com.crs.flipkart.bean;

/**
 * @author Abhinav
 *
 */
public class Professor extends User{
	private String Department;
	
	public Professor() {
		super();
	}

	public String getDepartment() {
		return Department;
	}

	public void setDepartment(String department) {
		Department = department;
	}
}
