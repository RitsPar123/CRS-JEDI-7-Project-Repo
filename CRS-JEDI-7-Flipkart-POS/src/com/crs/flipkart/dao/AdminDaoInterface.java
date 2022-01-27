/**
 * 
 */
package com.crs.flipkart.dao;

import java.util.List;
import java.util.Set;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Professor;
import com.crs.flipkart.bean.Student;

/**
 * @author Abhinav
 *
 */
public interface AdminDaoInterface {
	public boolean addCourse(Course course);
	public boolean deleteCourse(String id);
	public boolean addProfessor(Professor professor);
	public boolean approveStudent(String studentId);
	public List<Student> viewPendingApproval();
	public List<Course> viewCourse();
	public Set<String> viewSelectedCourse(String studentId);
	public int getCourseList(String courseId);
	public boolean updateRegistered(String studentId);
	public Student viewStudentData(String studentId);
}
