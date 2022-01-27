/**
 * 
 */
package com.crs.flipkart.business;

import java.util.List;
import java.util.Set;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Professor;
import com.crs.flipkart.bean.RegisteredCourses;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.dao.AdminDaoInterface;
import com.crs.flipkart.dao.AdminDaoOperation;

/**
 * @author Abhinav
 *
 */
public class AdminService implements AdminServiceInterface {

	AdminDaoInterface adminDaoOp = new AdminDaoOperation();
	
	/*Adding course in course table */    
	public boolean addCourse(Course course) {
		return adminDaoOp.addCourse(course);
	}
	
	
	/* Deleting course from the course table using course id */
	@Override
	public boolean deleteCourse(String id) {
		// TODO Auto-generated method stub
		return adminDaoOp.deleteCourse(id);
	}
	
	/*Adding professor in professor table */
	@Override
	public boolean addProfessor(Professor professor) {
		// TODO Auto-generated method stub
		return adminDaoOp.addProfessor(professor);
	}
	
	/*approves student using studentId in student table */
	@Override
	public boolean approveStudent(String studentId) {
		// TODO Auto-generated method stub
		return adminDaoOp.approveStudent(studentId);
	}
	
	/*admin views Pending Approval */
	@Override
	public List<Student> viewPendingApproval() {
		// TODO Auto-generated method stub
		return adminDaoOp.viewPendingApproval();
	}
	
	/*Method to view course from course table*/
	@Override
	public List<Course> viewCourse() {
		// TODO Auto-generated method stub
		return adminDaoOp.viewCourse();
	}
	
	/*Method to view courses selected by the student*/
	@Override
	public Set<String> viewSelectedCourse(String studentId) {
		// TODO Auto-generated method stub
		return adminDaoOp.viewSelectedCourse(studentId);
	}
	
	/*Method to get course List*/
	@Override
	public int getCouseList(String courseId) {
		// TODO Auto-generated method stub
		return adminDaoOp.getCourseList(courseId);
	}
	/*Method to get student registered*/
	@Override
	public boolean updateRegistered(String studentId) {
		// TODO Auto-generated method stub
		return adminDaoOp.updateRegistered(studentId);
	}
	
	/*Method to view Student Data using user and student table*/
	@Override
	public Student viewStudentData(String studentId) {
		// TODO Auto-generated method stub
		return adminDaoOp.viewStudentData(studentId);
	}
	@Override
	public List<RegisteredCourses> activateGradeCard(String studentId) {
		// TODO Auto-generated method stub
		return adminDaoOp.activateGradeCard(studentId);
	}
	@Override
	public boolean approveStudentRegistration(String SId) {
		// TODO Auto-generated method stub
		return adminDaoOp.approveStudentRegistration(SId);
	}

}
