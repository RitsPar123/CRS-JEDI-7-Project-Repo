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
	private String courseId;
	private String studentId;
	private int isRegistered;
	private int grade;
	
	public RegisteredCourses() {}

	/**
	 * @return the courseId
	 */
	public String getCourseId() {
		return courseId;
	}

	/**
	 * @param courseId the courseId to set
	 */
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	/**
	 * @return the studentId
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
	 * @return the isRegistered
	 */
	public int getIsRegistered() {
		return isRegistered;
	}

	/**
	 * @param isRegistered the isRegistered to set
	 */
	public void setIsRegistered(int isRegistered) {
		this.isRegistered = isRegistered;
	}

	/**
	 * @return the grade
	 */
	public int getGrade() {
		return grade;
	}

	/**
	 * @param grade the grade to set
	 */
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	
	
	
}
