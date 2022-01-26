/**
 * 
 */
package com.crs.flipkart.business;

import java.util.ArrayList;
import java.util.List;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.dao.ProfessorDaoInterface;
import com.crs.flipkart.dao.ProfessorDaoOperation;

/**
 * @author hardik.kothari
 *
 */
public class ProfessorService {
	
	ProfessorDaoInterface professorDaoInterface = new ProfessorDaoOperation();

	public void selectCourse(String profId,String courseid,String coursename) {
		professorDaoInterface.selectCourse(profId,courseid,coursename);
		//table-course
	}
	public void viewRegisteredCourses(String id) {
		
		List<Course> RegisteredCourse = new ArrayList<Course>();
		RegisteredCourse=professorDaoInterface.viewRegisteredCourses(id);
		
		System.out.println();
		for(Course rc: RegisteredCourse) {
			System.out.println("\tCourse ID :" + rc.getCourseId() +"\tCourse Name: "+ rc.getCourseName());
		}
		System.out.println();
		
		//table-course
	}
	public void addGrades(String professorId,String courseId,String studentId,int grade) {
		professorDaoInterface.addGrades( professorId,courseId,studentId,grade);
		//table-grades
	}
	public void showCourses() {
		List<Course> courseList = professorDaoInterface.showCourses();
		
		System.out.println();
		for(Course course :courseList)
		{
			System.out.println("\tCourse ID :" + course.getCourseId() +"\tCourse Name: "+ course.getCourseName() + " \tSeats:" + course.getCount() );
		}
		System.out.println();
		//table-course
	}
	
	public void viewRegisteredStudents(String id, String courseId)
	{
		professorDaoInterface.viewRegisteredStudents(id,courseId);
	}

}
