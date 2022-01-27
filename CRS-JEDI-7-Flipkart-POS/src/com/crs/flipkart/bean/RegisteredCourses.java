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
	
	public RegisteredCourses() {}
	
	public String getCourseId() {
		return CourseId;
	}
	public void setCourseId(String courseId) {
		CourseId = courseId;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public int getIsRegistered() {
		return IsRegistered;
	}
	public void setIsRegistered(int isRegistered) {
		IsRegistered = isRegistered;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	
	
}
