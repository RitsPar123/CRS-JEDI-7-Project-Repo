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
	 * @param studentId : student id
	 * @param courseid: course id
	 */
	 public GradeNotAddedException(String studentId,String courseid)
	 {
		 this.sid=studentId;
	 }
	 
	 /**
	  * Getter function for studentId
	  * @return sid
	  */
	 public String getStudentId()
	 {
		 return sid;
	 }

	 /**
	  * Message to be thrown
	  */
	  public String getMessage() {
		  return "Marks for student with id : "+sid+" and course with id: "+courseid+" cannot be added";
	  }
}

