/**
 * 
 */
package com.crs.flipkart.dao;

import java.util.List;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Professor;

/**
 * @author Abhinav
 *
 */
public interface AdminDaoInterface {
	public boolean addCourse(Course course);
	public boolean deleteCourse(String id);
	public boolean addProfessor(Professor professor);
	public List<Course> getAllCourse();
}
