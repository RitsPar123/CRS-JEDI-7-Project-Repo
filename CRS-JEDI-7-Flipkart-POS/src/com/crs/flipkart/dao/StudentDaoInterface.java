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
}
