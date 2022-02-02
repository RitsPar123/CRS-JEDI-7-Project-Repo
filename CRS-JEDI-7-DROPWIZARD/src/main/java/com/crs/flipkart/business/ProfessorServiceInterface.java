/**
 * 
 */
package com.crs.flipkart.business;

import java.util.List;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.exception.CourseFoundException;
import com.crs.flipkart.exception.NoCourseFoundException;

/**
 * @author hardik.kothari
 *
 */
public interface ProfessorServiceInterface {
	
	/**
	 * Method to Select Course for Professor to Teach using SQL commands
	 * @param course
	 * @param profId
	 * @param courseid 
	 * @param coursename
	 * @return true if successful / false if failure
	 */
	public Boolean selectCourse(String profId, String courseid, String coursename);
	
	
	/**
	 * Method for viewing Professor's Registered Courses using SQL commands
	 * @param profId
	 * @return List of Courses
	 * @throws NoCourseFoundException 
	 */
	public List<Course> viewRegisteredCourses(String id) throws NoCourseFoundException;
	
	
	/**
	 * Method to Add Grades using SQL commands
	 * @param professorId
	 * @param courseId
	 * @param studentId 
	 * @param grade
	 * @return true if successful / false if failure
	 */
	
	public Boolean addGrades(String professorId, String courseId, String studentId, int grade);
	
	/**
	 * Method to Show Course Available using SQL commands
	 * @return List of Courses
	 * @throws NoCourseFoundException 
	 */
	
	public List<Course>  showCourses() throws NoCourseFoundException;
	
	/**
	 * Method to view Registered Students in Professor's Course using SQL commands
	 * @param course
	 * @return List of Student
	 */
	
	public List<Student>  viewRegisteredStudents(String id, String courseId) ;


}
