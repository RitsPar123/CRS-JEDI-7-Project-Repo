/**
 * 
 */
package com.crs.flipkart.business;

import java.util.List;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.exception.NoCourseFoundException;

/**
 * @author hardik.kothari
 *
 */
public interface ProfessorServiceInterface {
	
public Boolean selectCourse(String profId, String courseid, String coursename);
	
	public List<Course> viewRegisteredCourses(String id) throws NoCourseFoundException;
	
	public Boolean addGrades(String professorId, String courseId, String studentId, int grade);
	
	public List<Course>  showCourses() throws NoCourseFoundException;
	
	public List<Student>  viewRegisteredStudents(String id, String courseId) ;


}
