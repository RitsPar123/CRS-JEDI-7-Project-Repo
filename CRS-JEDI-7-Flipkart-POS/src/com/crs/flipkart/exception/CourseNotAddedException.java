package com.crs.flipkart.exception;

@SuppressWarnings("serial")
public class CourseNotAddedException extends Exception{
	

		private String courseid;
		 
		/**
		 * Constructor
		 * @param Id : course id
		 */
		 public CourseNotAddedException(String Id)
		 {
			 this.courseid=Id;
		 }
		 
		 /**
		  * Getter function for courseId
		  * @return courseid
		  */
		 public String getcourseId()
		 {
			 return courseid;
		 }
		 
		 /**
		  * Message thrown by exception
		  */
		 public String getMessage() {
			 return "Course with courseId : "+ courseid + " cannot be added";
		 }
		 
}

