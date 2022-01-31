/**
 * 
 */
package com.crs.flipkart.business;

import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Professor;
import com.crs.flipkart.bean.RegisteredCourses;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.dao.AdminDaoInterface;
import com.crs.flipkart.dao.AdminDaoOperation;
import com.crs.flipkart.dao.StudentDaoOperation;
import com.crs.flipkart.exception.CourseFoundException;
import com.crs.flipkart.exception.CourseNotDeletedException;
import com.crs.flipkart.exception.CourseNotFoundException;
import com.crs.flipkart.exception.ProfessorNotAddedException;
import com.crs.flipkart.exception.StudentNotFoundForApprovalException;
import com.crs.flipkart.exception.UserIdAlreadyInUseException;
import com.crs.flipkart.exception.UserNotAddedException;

/**
 * @author Abhinav
 *
 */
public class AdminService implements AdminServiceInterface {

	 private static Logger logger = Logger.getLogger(AdminService.class);

	AdminDaoInterface adminDaoOp = new AdminDaoOperation();
	
	/*Adding course in course table */    
	public boolean addCourse(Course course) throws CourseFoundException {
		logger.info("Adding course in the course-catalogue");
		return adminDaoOp.addCourse(course);
	}
	
	
	/* Deleting course from the course table using course id */
	@Override
	public boolean deleteCourse(String id) throws CourseNotFoundException, CourseNotDeletedException {
		logger.info("Deleting course in the course-catalogue");
		return adminDaoOp.deleteCourse(id);
		// TODO Auto-generated method stub
	}
	
	@Override
	public boolean addProfessor(Professor professor) throws UserIdAlreadyInUseException, ProfessorNotAddedException {
		// TODO Auto-generated method stub
		logger.info("Adding professor");
		return adminDaoOp.addProfessor(professor);
	}
	
	/*approves student using studentId in student table */
	@Override
	public boolean approveStudent(String studentId) throws StudentNotFoundForApprovalException {
		// TODO Auto-generated method stub
		logger.info("Approving student");
		return adminDaoOp.approveStudent(studentId);
	}
	
	/*admin views Pending Approval */
	@Override
	public List<Student> viewPendingApproval() {
		// TODO Auto-generated method stub
		logger.info("Showing pending approvals of students semester registration");
		return adminDaoOp.viewPendingApproval();
	}
	
	/*Method to view course from course table*/
	@Override
	public List<Course> viewCourse() {
		// TODO Auto-generated method stub
		logger.info("Showing courses from the course catalogue");
		return adminDaoOp.viewCourse();
	}
	
	/*Method to view courses selected by the student*/
	@Override
	public Set<String> viewSelectedCourse(String studentId) {
		// TODO Auto-generated method stub
		
		logger.info("Showing Selected Courses");
		return adminDaoOp.viewSelectedCourse(studentId);
	}
	
	/*Method to get course List*/
	@Override
	public int getCouseList(String courseId) {
		// TODO Auto-generated method stub
		logger.info("Getting Course List");
		return adminDaoOp.getCourseList(courseId);
	}
	/*Method to get student registered*/
	@Override
	public boolean updateRegistered(String studentId,String s1, String s2) {
		// TODO Auto-generated method stub
		logger.info("Updating Student Registration");
		return adminDaoOp.updateRegistered(studentId,s1,s2);
	}
	
	/*Method to view Student Data using user and student table*/
	@Override
	public Student viewStudentData(String studentId) {
		// TODO Auto-generated method stub
		logger.info("Viewing student data");
		return adminDaoOp.viewStudentData(studentId);
	}
	@Override
	public List<RegisteredCourses> activateGradeCard(String studentId) {
		// TODO Auto-generated method stub
		logger.info("Activating grade card");
		return adminDaoOp.activateGradeCard(studentId);
	}
	@Override
	public boolean approveStudentRegistration(String SId) {
		// TODO Auto-generated method stub
		logger.info("Approving student registration");
		return adminDaoOp.approveStudentRegistration(SId);
	}


	@Override
	public boolean updateCourse(Set<String> courseList) {
		// TODO Auto-generated method stub
		logger.info("Updating Courses in the list");
		return adminDaoOp.updateCourse(courseList);
	}


	@Override
	public boolean addUser(String id, String password,String name) throws UserNotAddedException, UserIdAlreadyInUseException {
		// TODO Auto-generated method stub
		logger.info("Adding a new user");
		return adminDaoOp.addUser(id,password,name);
	}

}
