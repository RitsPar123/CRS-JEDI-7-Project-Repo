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

/*Methods for Admin*/ 
public interface AdminServiceInterface {
	public boolean addCourse(Course course) throws CourseFoundException;
	public boolean deleteCourse(String id) throws CourseNotFoundException, CourseNotDeletedException;
	public boolean addProfessor(Professor professor) throws UserIdAlreadyInUseException, ProfessorNotAddedException;
	public boolean approveStudent(String studentUserId) throws StudentNotFoundForApprovalException;
	public List<Student> viewPendingApproval();
	public List<Course> viewCourse();
	public Set<String> viewSelectedCourse(String studentId);
	public int getCouseList(String c);
	public boolean updateRegistered(String studentId, String s1, String s2);
	public Student viewStudentData(String studentId);
	public List<RegisteredCourses> activateGradeCard(String studentId);
	public boolean approveStudentRegistration(String SId);
	public boolean updateCourse(Set<String> courseList);
	public boolean addUser(String id, String password, String name) throws UserNotAddedException, UserIdAlreadyInUseException;
}
