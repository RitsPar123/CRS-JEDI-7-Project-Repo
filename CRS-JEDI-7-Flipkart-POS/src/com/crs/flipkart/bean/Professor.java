/**
 * 
 */
package com.crs.flipkart.bean;

/**
 * @author Upasana Singh
 *
 */
public class Professor extends User{
	private String Department;
	
	public Professor() {
		super();
	}


	/**
	 * @return the department
	 */
	public String getDepartment() {
		return Department;
	}



	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		Department = department;
	}
	
}

