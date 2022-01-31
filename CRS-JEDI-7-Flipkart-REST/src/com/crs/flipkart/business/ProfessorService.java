/**
 * 
 */
package com.crs.flipkart.business;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.dao.ProfessorDaoInterface;
import com.crs.flipkart.dao.ProfessorDaoOperation;
import com.crs.flipkart.exception.NoCourseFoundException;
import com.crs.flipkart.exception.StudentNotFoundException;

/**
 * @author hardik.kothari
 *
 */
public class ProfessorService {
	private static Logger logger = Logger.getLogger(ProfessorService.class);
	ProfessorDaoInterface professorDaoInterface = new ProfessorDaoOperation();


	/**
	 * Method that lets professor select a course with a particular courseid and coursename
	 * @param profId
	 * @param courseid
	 * @param coursename
	 */
	public void selectCourse(String profId, String courseid, String coursename) {
		logger.info("Selecting the course");
		professorDaoInterface.selectCourse(profId, courseid, coursename);
		// table-course
	}

	/**
	 * Method that lets professor View Registered Courses
	 * @param id: Professor's id
	 */
	public void viewRegisteredCourses(String id) throws NoCourseFoundException{
		logger.info("Viewing Registered Course");
		List<Course> RegisteredCourse = new ArrayList<Course>();
		RegisteredCourse = professorDaoInterface.viewRegisteredCourses(id);

		System.out.println();
		if(RegisteredCourse.size()>0) {
		for (Course rc : RegisteredCourse) {
			System.out.println("\tCourse ID :" + rc.getCourseId() + "\tCourse Name: " + rc.getCourseName());
		}
		System.out.println();
		} 
		else
			throw new NoCourseFoundException(id);
		// table-course
	}

	/**
	 * Method which is used to add Grades by the professor
	 * @param professorId : Id of the professor
	 * @param courseId : Id of the course to be added grade
	 * @param studentId : Id of the student to be added grade
	 * @param grade
	 */
	public void addGrades(String professorId, String courseId, String studentId, int grade) {

		logger.info("Adding grades of the student");
		professorDaoInterface.addGrades(professorId, courseId, studentId, grade);
		// table-grades
	}

	/**
	 * Method that shows courses available for professor to select from
	 */
	public void showCourses() throws NoCourseFoundException{

		logger.info("Showing Courses");
		List<Course> courseList = professorDaoInterface.showCourses();

		System.out.println();
		if(courseList.size()>0) {
		for (Course course : courseList) {
			System.out.println("\tCourse ID :" + course.getCourseId() + "\tCourse Name: " + course.getCourseName()
					+ " \tSeats:" + course.getCount());
		}
		System.out.println();
		}
		else
			throw new NoCourseFoundException();
		// table-course
	}

	
	/** 
	 * Method that allows Professor to view students registered for a particular courseId
	 * @param id : professor id
	 * @param courseId: id of the course
	 */
	public void viewRegisteredStudents(String id, String courseId) {
		logger.info("Viewing Registered Courses");
		try {
		professorDaoInterface.viewRegisteredStudents(id, courseId);
		} 
		catch(StudentNotFoundException ex) {
			logger.info("Exception : "+ex.getMessageWithCourse());
		}
	}

}
