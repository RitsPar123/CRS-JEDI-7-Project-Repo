/**
 * 
 */
package com.crs.flipkart.business;

import java.util.List;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.dao.RegisteredCoursesDaoInterface;
import com.crs.flipkart.dao.RegisteredCoursesDaoOperation;

/**
 * @author harsh
 *
 */
public class RegisteredCoursesService implements RegisteredCoursesServiceInterface{
	public void generateReportCard() {
		
	}
	public void calculateGpa() {
		
	}
	public List<Course> getSelectedCourses(String studentId) {
		RegisteredCoursesDaoInterface registeredCoursesDaoInterface = new RegisteredCoursesDaoOperation();
		return registeredCoursesDaoInterface.getSelectedCourses(studentId);
	}
}
