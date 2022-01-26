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
	public void generateReportCard();
	public void calculateGpa();
	public List<Course> getSelectedCourses(String id);
}
