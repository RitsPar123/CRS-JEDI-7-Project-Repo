/**
 * 
 */
package com.crs.flipkart.business;

import com.crs.flipkart.dao.ProfessorDaoInterface;

/**
 * @author hardik.kothari
 *
 */
public class ProfessorService {
	
	ProfessorDaoInterface professorDaoInterface = new ProfessorDaoInterface();

	public void selectCourse(String profId,String courseid,String coursename) {
		professorDaoInterface.selectCourse(profId,courseid,coursename);
		//table-course
	}
	public void viewRegisteredCourses(String id) {
		professorDaoInterface.viewRegisteredCourses(id);
		//table-course
	}
	public void addGrades(String courseId,String studentId,int grade) {
		professorDaoInterface.addGrades(courseId,studentId,grade);
		//table-grades
	}
	public void showCourses() {
		professorDaoInterface.showCourses();
		//table-course
	}

}
