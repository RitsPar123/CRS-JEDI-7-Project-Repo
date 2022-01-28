/**
 * 
 */
package com.crs.flipkart.exception;

/**
 * @author srini
 *
 */
@SuppressWarnings("serial")
public class GradeNotAddedException extends Exception{
	
	private String sid;
	private String courseid;
	 
	/**
	 * Constructor
	 * @param studentId
	 */
	 public GradeNotAddedException(String studentId,String courseid)
	 {
		 this.sid=studentId;
	 }
	 
	 /**
	  * Getter function for studentId
	  * @return
	  */
	 public String getStudentId()
	 {
		 return sid;
	 }

	 /**
	  * 
	  */
	  public String getMessage() {
		  return "Marks for student with id : "+sid+" and course with id: "+courseid+"   cannot be added";
	  }
}

