/**
 * 
 */
package com.crs.flipkart.dao;

import java.util.List;
import java.util.Set;


import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Professor;
import com.crs.flipkart.bean.RegisteredCourses;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.exception.CourseNotAddedException;

/**
 * @author Abhinav
 *
 */
public interface AdminDaoInterface {

	/**
	 * Method to Add Course using SQL commands
	 * @param course
	 * @return true if successful / false if failure
	 */
	public boolean addCourse(Course course);

	/**
	 * Method to delete courses using SQL commands
	 * @param id
	 * @return true if successful / false if failure
	 */
	public boolean deleteCourse(String id);

	/**
	 * Method to allot professor to a course using SQL commands
	 * @param professor
	 * @return true if successful / false if failure
	 */
	public boolean addProfessor(Professor professor);
	
	/**
	 * Method to get all courses using SQL commands
	 * @return List of courses
	 */
	public List<Course> getAllCourse();

	/**
	 * Method to Approve student registration for fee payment using SQL commands
	 * @param studentId
	 * @return true if successful / false if failure
	 */
	public boolean approveStudent(String studentId);

	/**
	 * Method to View Pending Course registrations using SQL commands
	 * @return List of students to yet be approved
	 */
	public List<Student> viewPendingApproval();

	/**
	 * Method to View all courses using SQL commands
	 * @return List of all courses
	 */
	public List<Course> viewCourse();

	/**
	 * Method to view selected courses using SQL commands
	 * @param studentId
	 * @return Set of all selected courses
	 */
	public Set<String> viewSelectedCourse(String studentId);

	/**
	 * Method to get seatCount for a course
	 * @param courseId
	 * @return Seats remaining for a course
	 */
	public int getCourseList(String courseId);

	/**
	 * Method to approve students who have paid their fees using SQL commands
	 * @param studentId
	 * @return true if successful / false if failure
	 */
	public boolean updateRegistered(String studentId, String s1, String s2);

	/**
	 * Method to view details of a student using SQL commands
	 * @param studentId
	 * @return student object
	 */
	public Student viewStudentData(String studentId);

	/**
	 * Method to enable report card view to student using SQL commands
	 * @param studentId 
	 */
	public List<RegisteredCourses> activateGradeCard(String studentId);

	/**
	 * Method to approve the registration of students using SQL commands
	 * @param SId : Id of the student
	 * @return true if successful / false if failure
	 */
	public boolean approveStudentRegistration(String SId);

	/**
	 * Method to delete registrations by a student using SQL commands
	 * @param studentId
	 */
	public boolean deleteEntry(String studentId);

	/**
	 * Method to update seatcount of courses using SQL commands
	 * @param courseList
	 */
	public boolean updateCourse(Set<String> courseList);

	/**
	 * Method to add user using SQL commands
	 * @param id
	 * @param password
	 * @param name
	 */
	public boolean addUser(String id, String password, String name);
}
