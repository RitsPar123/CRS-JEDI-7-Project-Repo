/**
 * 
 */
package com.crs.flipkart.business;

import java.util.List;

import org.apache.log4j.Logger;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.dao.RegisteredCoursesDaoInterface;
import com.crs.flipkart.dao.RegisteredCoursesDaoOperation;

/**
 * @author harsh
 *
 */
public class RegisteredCoursesService implements RegisteredCoursesServiceInterface {
	private static Logger logger = Logger.getLogger(RegisteredCoursesService.class);
	RegisteredCoursesDaoInterface registeredCoursesDaoInterface = new RegisteredCoursesDaoOperation();

	public void generateReportCard() {

	}

	public void calculateGpa() {

	}

	public List<Course> getSelectedCourses(String studentId) {
		logger.info("Getting selected courses");
		return registeredCoursesDaoInterface.getSelectedCourses(studentId);
	}

	public List<Course> getApprovedCourses(String studentId) {
		logger.info("Showing approved Courses");
		return registeredCoursesDaoInterface.getApprovedCoursesById(studentId);
	}

	@Override
	public int getStatus(String studentId) {

		// TODO Auto-generated method stub
		logger.info("Showing status");
		return registeredCoursesDaoInterface.getStatus(studentId);
	}

	@Override
	public boolean updateStatus(String studentId) {
		// TODO Auto-generated method stub
		logger.info("Updating status");
		return registeredCoursesDaoInterface.updateStatus(studentId);
	}
}
