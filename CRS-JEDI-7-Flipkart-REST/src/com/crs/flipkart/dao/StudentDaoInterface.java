/**
 * 
 */
package com.crs.flipkart.dao;

import com.crs.flipkart.bean.Student;

/**
 * @author Abhinav
 *
 */
public interface StudentDaoInterface {

	/**
	 * Method to signup a new student using SQL commands
	 * @param student
	 * @return studentid if successful / null if failure
	 */
	public String signup(Student student);

	/**
	 * Method to get registration status of student
	 * @param id : student's id
	 * @return status of registration (0-not approved, 1-approved but not paid fee, 2- registered)
	 */
	public int getRegistrationStatus(String id);
	
}
