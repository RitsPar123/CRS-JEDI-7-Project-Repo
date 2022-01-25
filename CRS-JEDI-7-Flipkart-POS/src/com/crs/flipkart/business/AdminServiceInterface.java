/**
 * 
 */
package com.crs.flipkart.business;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Professor;

/**
 * @author Abhinav
 *
 */
public interface AdminServiceInterface {
	public boolean addCourse(Course course);
	public boolean deleteCourse(String id);
	public boolean addProfessor(Professor professor);
}
