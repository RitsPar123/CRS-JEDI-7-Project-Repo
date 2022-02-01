/**
 * 
 */
package com.crs.flipkart.dao;

import java.util.List;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.RegisteredCourses;
import com.crs.flipkart.exception.CourseNotFoundException;

/**
 * @author harsh
 *
 */
public interface RegisteredCoursesDaoInterface {
	
	public List<Course> getApprovedCoursesById(String id);
	public boolean addCourse(String courseId,String SId);
	public void dropCourse(String courseId,String SId);
	public boolean hasCourse(String courseId,String Sid);
	public List<Course> getSelectedCourses(String id);
	public int getStatus(String studentId);
	public boolean updateStatus(String studentId);
	public boolean isCourseAvailable(String courseid) throws CourseNotFoundException;
}
