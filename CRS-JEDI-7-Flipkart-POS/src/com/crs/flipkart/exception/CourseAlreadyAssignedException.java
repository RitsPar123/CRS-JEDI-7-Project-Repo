/**
 * 
 */
package com.crs.flipkart.exception;

/**
 * @author srini
 *
 */
@SuppressWarnings("serial")
public class CourseAlreadyAssignedException extends Exception{
		
	private String courseid; 
	
	public CourseAlreadyAssignedException(String courseid) {
		this.courseid = courseid; 
	}
	
	public String getMessage() {
		return "Course with id : "+ courseid+ " does not exist or already been taken";	
		}
	
}
