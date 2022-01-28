/**
 * 
 */

package com.crs.flipkart.exception;

/**
 * @author srini
 *
 */
@SuppressWarnings("serial")
public class UserNotVerifiedException extends Exception{
	
	String sid; 
	
	/**
	 * Parameterized constructor
	 * @param sid
	 */
	public UserNotVerifiedException(String sid) {
		this.sid = sid;
	}

	/**
	 * Message thrown by exception
	 */
	public String getMessage(){
		return "user with id : "+sid+"  could not be verified";
	}
	
}
