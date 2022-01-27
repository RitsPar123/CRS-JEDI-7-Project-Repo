/**
 * 
 */
package com.crs.flipkart.bean;

import java.util.List;

/**
 * @author harsh
 *
 */
public class RegisteredCourses {
	private String CourseId;
	private String studentId;
	private int IsRegistered;
	private int grade;
	
	/**
	 * Default constructor
	 */
	public RegisteredCourses() {}
	
	/**
	 * Method to get courseId
	 * @return
	 */
	public String getCourseId() {
		return CourseId;
	}

	
	/** 
	 * Mthod to Set CourseId
	 * @param courseId
	 */
	public void setCourseId(String courseId) {
		CourseId = courseId;
	}
	
	/** Method to get studentID
	 * @return String
	 */
	public String getStudentId() {
		return studentId;
	}
	
	/** 
	 * Method to set studentId
	 * @param studentId
	 */
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	
	/** 
	 * Method to get IsRegistered Status
	 * @return int
	 */
	public int getIsRegistered() {
		return IsRegistered;
	}
	
	/** 
	 * Method to set IsRegistered Status
	 * @param isRegistered
	 */
	public void setIsRegistered(int isRegistered) {
		IsRegistered = isRegistered;
	}
	
	/** 
	 * Method to get grade
	 * @return int
	 */
	public int getGrade() {
		return grade;
	}
	
	/** 
	 * Method to set grade
	 * @param grade
	 */
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	
	
}
