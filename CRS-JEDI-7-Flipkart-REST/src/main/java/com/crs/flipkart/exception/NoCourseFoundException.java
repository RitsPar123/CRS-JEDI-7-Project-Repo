/**
 * 
 */
package com.crs.flipkart.exception;

/**
 * @author srini
 *
 */
public class NoCourseFoundException extends Exception{
	 
	
	private String profid; 
	
	public NoCourseFoundException() {
		
	}
	
	public NoCourseFoundException(String profid) {
		this.profid = profid;
	}
	 /**
	  * Message to be thrown
	  */
	  public String getMessage() {
		  return "No courses found in the database";
	  }
	  
	  public String getMessagewithid(){
		  return "Professor with id: " +this.profid+" has no registered courses";
	  }
}
