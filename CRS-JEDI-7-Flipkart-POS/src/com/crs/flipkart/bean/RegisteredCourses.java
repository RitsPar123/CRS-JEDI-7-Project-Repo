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
	private String studentId;
	List<Course> selectedCourses;
	double gpa;
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
	 * @return the selectedCourses
	 */
	public List<Course> getSelectedCourses() {
		return selectedCourses;
	}
	/**
	 * @param selectedCourses the selectedCourses to set
	 */
	public void setSelectedCourses(List<Course> selectedCourses) {
		this.selectedCourses = selectedCourses;
	}
	/**
	 * @return the gpa
	 */
	public double getGpa() {
		return gpa;
	}
	/**
	 * @param gpa the gpa to set
	 */
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	
	
	
}
