/**
 * 
 */
package com.crs.flipkart.business;

import java.util.List;

import com.crs.flipkart.bean.Course;

/**
 * @author hardik.kothari
 *
 */
public interface RegisteredCoursesServiceInterface {
	
	public List<Course> getSelectedCourses(String id);
	public int getStatus(String studentId);
	public boolean updateStatus(String studentId);
}
