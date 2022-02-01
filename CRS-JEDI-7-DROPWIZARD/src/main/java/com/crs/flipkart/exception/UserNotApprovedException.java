/**
 * 
 */
package com.crs.flipkart.exception;

import com.crs.flipkart.bean.Professor;

/**
 * @author srini
 *
 */
@SuppressWarnings("serial")
public class UserNotApprovedException extends Exception{
	
	String id; 
	
    /**
     * Parameterized constructor
     * @param id
     */
	public UserNotApprovedException(String id) {
		this.id = id;
	}

    public String getMessage(){
		return "user with id : "+id+"  could not be verified";
    }
	
	
}
