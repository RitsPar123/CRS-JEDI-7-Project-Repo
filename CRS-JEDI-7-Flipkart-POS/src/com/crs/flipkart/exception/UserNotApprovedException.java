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
public class UserNotVerfiedException extends Exception{
	
	String id; 
	
    /**
     * Parameterized constructor
     * @param id
     */
	public UserNotVerfiedException(String id) {
		this.id = id;
	}

    public String getMessage(){
		return "user with id : "+sid+"  could not be verified";
    }
	
	
}
