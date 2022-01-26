/**
 * 
 */
package com.crs.flipkart.dao;

import java.util.List;
<<<<<<< HEAD
=======
import java.util.Set;
>>>>>>> 5906df70e161e2e26ef745be379a7f3743b912ff

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
<<<<<<< HEAD
	public List<Course> getAllCourse();
=======
	public boolean approveStudent(String studentId);
	public List<Student> viewPendingApproval();
	public List<Course> viewCourse();
	public Set<String> viewSelectedCourse(String studentId);
	public int getCourseList(String courseId);
	public boolean updateRegistered(String studentId);
>>>>>>> 5906df70e161e2e26ef745be379a7f3743b912ff
}
