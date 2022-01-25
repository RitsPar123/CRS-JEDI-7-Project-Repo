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
public class ProfessorDaoOperation implements ProfessorDaoInterface {

	@Override
	public boolean selectCourse(String courseid, String coursename) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Course> viewRegisteredCourses(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addGrades(String courseId, String studentId, int grade) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Course> showCourses(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
