/**
 * 
 */
package com.crs.flipkart.business;

import java.util.List;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Professor;
import com.crs.flipkart.bean.Student;

/**
 * @author Abhinav
 *
 */
public interface AdminServiceInterface {
	public boolean addCourse(Course course);
	public boolean deleteCourse(String id);
	public boolean addProfessor(Professor professor);
	public boolean approveStudent(String studentUserId);
	public List<Student> viewPendingApproval();
}
