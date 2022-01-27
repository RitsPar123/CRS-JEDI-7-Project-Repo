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
	public boolean updateRegistered(String studentId);

	/**
	 * Method to view details of a student using SQL commands
	 * @param studentId
	 * @return student object
	 */
	public Student viewStudentData(String studentId);
	public List<RegisteredCourses> activateGradeCard(String studentId);
	public boolean approveStudentRegistration(String SId);
}
