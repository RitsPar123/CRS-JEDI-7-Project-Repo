/**
 * 
 */
package com.crs.flipkart.business;

import java.util.List;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.CourseCatalog;
import com.crs.flipkart.bean.Payment;
import com.crs.flipkart.bean.RegisteredCourses;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.exception.StudentNotRegisteredException;

/**
 * @author hardik.kothari
 *
 */

 /*Interface containing method for student signup */
public interface StudentServiceInterface {
	
		public boolean signup(Student s);

		public List<Course> viewRegisteredCourses(String id);

		public void register(String id);
		
		public List<RegisteredCourses> viewReportCard(String id);

}