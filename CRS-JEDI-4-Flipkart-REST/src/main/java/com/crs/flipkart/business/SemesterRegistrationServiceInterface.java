/**
 * 
 */
package com.crs.flipkart.business;

import java.util.List;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.CourseCatalog;
import com.crs.flipkart.bean.SemesterRegistration;
import com.crs.flipkart.exception.CourseNotFoundException;

/**
 * @author Abhinav
 *
 */

 /*Interface containing methods for Semester Registered of a student 
  *by adding ,droping and showing courses available for selection .
  */
public interface SemesterRegistrationServiceInterface {
	public boolean addCourse(String studentId, String courseId) throws CourseNotFoundException;
	
	public boolean dropCourse(String studentId, String courseId) throws Exception;
	
	public List<Course> showCourse();
}