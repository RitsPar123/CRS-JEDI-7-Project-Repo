/**
 * 
 */
package com.crs.flipkart.dao;

import java.util.List;

import com.crs.flipkart.bean.Course;

/**
 * @author Abhinav
 *
 */
public interface ProfessorDaoInterface {
	
	public boolean selectCourse(String profId, String courseid,String coursename) ;

	public List<Course> viewRegisteredCourses(String id) ;
	
	public boolean addGrades(String courseId,String studentId,int grade) ;
	
	public List<Course> showCourses() ;
	
}
