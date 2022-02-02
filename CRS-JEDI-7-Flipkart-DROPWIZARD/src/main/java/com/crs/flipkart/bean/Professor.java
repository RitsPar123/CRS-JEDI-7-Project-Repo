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
	
	/**
	 * Default constructor
	 */
	public Professor() {
		super();
	}


	/**
	 * Method to get Department of a professor
	 * @return the department
	 */
	public String getDepartment() {
		return Department;
	}



	/**Method to set Department of a professor
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		Department = department;
	}
	
}

