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
	
	RegisteredCoursesDaoInterface registeredCoursesDaoInterface = new RegisteredCoursesDaoOperation();
 	
	public void generateReportCard() {
		
	}
	public void calculateGpa() {
		
	}
	public List<Course> getSelectedCourses(String studentId) {
		return registeredCoursesDaoInterface.getSelectedCourses(studentId);
	}
	public List<Course> getApprovedCourses(String studentId) {
		return registeredCoursesDaoInterface.getApprovedCoursesById(studentId);
	}
	@Override
	public int getStatus(String studentId) {
		// TODO Auto-generated method stub
		return registeredCoursesDaoInterface.getStatus(studentId);
	}
	@Override
	public boolean updateStatus(String studentId) {
		// TODO Auto-generated method stub
		return registeredCoursesDaoInterface.updateStatus(studentId);
	}
}
