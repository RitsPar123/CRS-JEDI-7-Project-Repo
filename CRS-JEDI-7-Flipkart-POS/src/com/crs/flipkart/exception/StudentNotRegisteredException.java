/**
 * 
 */
package com.crs.flipkart.exception;

/**
 * @author srini
 *
 */
@SuppressWarnings("serial")
public class StudentNotRegisteredException extends Exception{
	
	private String sid; 
	
	/**
	 * Parameterized Constructor
	 * @param sid
	 */
	public StudentNotRegisteredException(String sid ) {
		this.sid = sid;
	}

	/**
	 * Message thrown when exception is encountered
	 */
	public String getMessage(){
		return "Student with id : "+sid+" is not registered for any course";
	}
}
