/**
 * 
 */
package com.crs.flipkart.exception;

/**
 * @author srini
 *
 */
@SuppressWarnings("serial")
public class StudentNotApprovedException extends Exception{
	
	String sid; 
	
	/**
	 * Parameterized constructor
	 * @param sid
	 */
	public StudentNotApprovedException(String sid) {
		this.sid = sid;
	}

	/**
	 * Message thrown by exception
	 */
	public String getMessage(){
		return "Student with id : "+sid+" could not be found / approved";
	}
	
}
