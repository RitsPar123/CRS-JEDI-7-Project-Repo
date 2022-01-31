/**
 * 
 */
package com.crs.flipkart.dao;

import java.util.List;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.exception.StudentNotFoundException;

/**
 * @author Abhinav
 *
 */
public interface ProfessorDaoInterface {
	
	/**
	 * Method to select courses to teach using SQL commands
	 * @param profId
	 * @param courseid
	 * @param coursename
	 * @return true if selection successful / false if failure
	 */
	public boolean selectCourse(String profId, String courseid,String coursename) ;

	/**
	 * Method to view registered courses using SQL commands
	 * @param id
	 * @return List of courses to be taught
	 */
	public List<Course> viewRegisteredCourses(String id) ;
	
	/**
	 * Method to add grades for a student using SQL commands 
	 * @param professorId
	 * @param courseId
	 * @param studentId
	 * @param grade
	 * @return true if successful / false if failure
	 */
	public boolean addGrades(String professorId ,String courseId,String studentId,int grade) ;
	
	/**
	 * Method to view all available courses using SQL commands
	 * @return List of available courses
	 */
	public List<Course> showCourses() ;
	
	/**
	 * Method to view all registered students for a particular course using SQL commands
	 * @param id
	 * @param courseId
	 * @return 
	 * @throws StudentNotFoundException 
	 */
	public List<Student> viewRegisteredStudents(String id, String courseId) throws StudentNotFoundException;
	
}
