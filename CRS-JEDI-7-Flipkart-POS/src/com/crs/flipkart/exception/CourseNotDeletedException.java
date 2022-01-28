/**
 * 
 */
package com.crs.flipkart.exception;

/**
 * @author srini
 *
 */
@SuppressWarnings("serial")
public class CourseNotDeletedException extends Exception{
	
	private String courseid;
	 
	/**
	 * Constructor
	 * @param courseId
	 */
	 public CourseNotDeletedException(String Id)
	 {
		 this.courseid=Id;
	 }
	 
	 /**
	  * Getter function for courseId
	  * @return
	  */
	 public String getcourseId()
	 {
		 return courseid;
	 }
	 
	 /**
	  * Message thrown by exception
	  */
	 public String getMessage() {
		 return "Course with courseId : "+ courseid + "cannot be deleted";
}
}
