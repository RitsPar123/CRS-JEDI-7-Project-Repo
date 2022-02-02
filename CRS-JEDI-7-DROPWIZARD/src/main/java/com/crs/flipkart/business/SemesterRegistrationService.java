/**
 * 
 */
package com.crs.flipkart.business;

import java.util.*;

import org.apache.log4j.Logger;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.CourseCatalog;
import com.crs.flipkart.bean.SemesterRegistration;
import com.crs.flipkart.dao.AdminDaoInterface;
import com.crs.flipkart.dao.AdminDaoOperation;
import com.crs.flipkart.dao.RegisteredCoursesDaoInterface;
import com.crs.flipkart.dao.RegisteredCoursesDaoOperation;
import com.crs.flipkart.exception.CourseNotFoundException;
import com.crs.flipkart.validator.StudentValidator;

/**
 * @author harsh
 *
 */
public class SemesterRegistrationService implements SemesterRegistrationServiceInterface {

	private static Logger logger = Logger.getLogger(SemesterRegistrationService.class);

	RegisteredCoursesDaoInterface registeredCoursesDaoInterface = new RegisteredCoursesDaoOperation();
	AdminDaoInterface adminDaoInterface = new AdminDaoOperation();
	List<Course> availableCourses = adminDaoInterface.getAllCourse();

	public boolean addCourse(String studentId, String courseId) throws CourseNotFoundException {

		logger.info("Adding course");

		try {
			registeredCoursesDaoInterface.isCourseAvailable(courseId);
		} catch (CourseNotFoundException ex) {
			throw ex;
		}
		List<Course> registeredCourseList = registeredCoursesDaoInterface.getSelectedCourses(studentId);
		if (registeredCoursesDaoInterface.hasCourse(courseId, studentId)
				|| StudentValidator.isRegistered(courseId, studentId, registeredCourseList)) {

			return false;
		}

		return registeredCoursesDaoInterface.addCourse(courseId, studentId);
	}

	public boolean dropCourse(String studentId, String courseId) throws Exception {

		logger.info("Dropping Course");

		if (!StudentValidator.isValidCourseCode(courseId, availableCourses)) {
			return false;
		}

		if (!registeredCoursesDaoInterface.hasCourse(courseId, studentId)) {

			return false;
		}

		try {
			registeredCoursesDaoInterface.dropCourse(courseId, studentId);
		} catch (Exception ex) {
			throw ex;
		}

		return true;
	}

	public List<Course> showCourse() {

		logger.info("Showing Course");
		// Fetch courses from course catalog

		return availableCourses;

	}

	/*
	 * Student can see selected courses
	 */
	public void showSelectedCourses(SemesterRegistration semesterRegistration) {

		logger.info("Showing selected courses");
		System.out.println("You have selected the following courses!");
		List<Course> selectedCourses = registeredCoursesDaoInterface
				.getSelectedCourses(semesterRegistration.getStudentId());

		selectedCourses.forEach(course -> {
			System.out.println("Course ID: " + course.getCourseId() + " Course Name : " + course.getCourseName());
		});

	}

}
