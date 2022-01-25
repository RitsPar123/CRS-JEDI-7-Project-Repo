/**
 * 
 */
package com.crs.flipkart.business;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Professor;
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

}
