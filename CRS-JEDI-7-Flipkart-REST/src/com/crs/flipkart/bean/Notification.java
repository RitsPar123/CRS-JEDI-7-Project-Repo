/**
 * 
 */
package com.crs.flipkart.bean;

/**
 * @author hardik.kothari
 *
 */
public class Notification {
	private String studentId;
	private String message;
	
	public Notification() {}
	
		/**
	 * Parameterized constructor
	 * @param id: notification id
	 * @param message: content of notification / message 
	 */
	public Notification(String id,String message) {
		this.studentId = id;
		this.message = message;
	}
	
	/**
	 * Method to get Student Id of student enrolled in the course
	 * @return Student Id
	 */
	
	public String getStudentId() {
		return studentId;
	}
	/**
	 * @param studentId the studentId to set
	 */
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	

}
