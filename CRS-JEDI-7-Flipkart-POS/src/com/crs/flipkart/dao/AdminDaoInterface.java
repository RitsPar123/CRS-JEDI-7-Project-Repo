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
	public boolean addCourse(Course course);
	public boolean deleteCourse(String id);
	public boolean addProfessor(Professor professor);
	public List<Course> getAllCourse();
	public boolean approveStudent(String studentId);
	public List<Student> viewPendingApproval();
	public List<Course> viewCourse();
	public Set<String> viewSelectedCourse(String studentId);
	public int getCourseList(String courseId);
	public boolean updateRegistered(String studentId, String s1, String s2);
	public Student viewStudentData(String studentId);
	public List<RegisteredCourses> activateGradeCard(String studentId);
	public boolean approveStudentRegistration(String SId);
	public boolean deleteEntry(String studentId);
	public boolean updateCourse(Set<String> courseList);
	public boolean addUser(String id, String password, String name);
}
