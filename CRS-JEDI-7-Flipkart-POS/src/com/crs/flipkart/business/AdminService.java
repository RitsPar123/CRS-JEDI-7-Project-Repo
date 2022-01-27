/**
 * 
 */
package com.crs.flipkart.business;

import java.util.List;
import java.util.Set;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Professor;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.dao.AdminDaoInterface;
import com.crs.flipkart.dao.AdminDaoOperation;

/**
 * @author Abhinav
 *
 */
public class AdminService implements AdminServiceInterface {

	AdminDaoInterface adminDaoOp = new AdminDaoOperation();
	
    
	public boolean addCourse(Course course) {
		return adminDaoOp.addCourse(course);
	}
	@Override
	public boolean deleteCourse(String id) {
		// TODO Auto-generated method stub
		return adminDaoOp.deleteCourse(id);
	}
	@Override
	public boolean addProfessor(Professor professor) {
		// TODO Auto-generated method stub
		return adminDaoOp.addProfessor(professor);
	}
	@Override
	public boolean approveStudent(String studentId) {
		// TODO Auto-generated method stub
		return adminDaoOp.approveStudent(studentId);
	}
	@Override
	public List<Student> viewPendingApproval() {
		// TODO Auto-generated method stub
		return adminDaoOp.viewPendingApproval();
	}
	@Override
	public List<Course> viewCourse() {
		// TODO Auto-generated method stub
		return adminDaoOp.viewCourse();
	}
	@Override
	public Set<String> viewSelectedCourse(String studentId) {
		// TODO Auto-generated method stub
		return adminDaoOp.viewSelectedCourse(studentId);
	}
	@Override
	public int getCouseList(String courseId) {
		// TODO Auto-generated method stub
		return adminDaoOp.getCourseList(courseId);
	}
	@Override
	public boolean updateRegistered(String studentId) {
		// TODO Auto-generated method stub
		return adminDaoOp.updateRegistered(studentId);
	}
	@Override
	public Student viewStudentData(String studentId) {
		// TODO Auto-generated method stub
		return adminDaoOp.viewStudentData(studentId);
	}

}
