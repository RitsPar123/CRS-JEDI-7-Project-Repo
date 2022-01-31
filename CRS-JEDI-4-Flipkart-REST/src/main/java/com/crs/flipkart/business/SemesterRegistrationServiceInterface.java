/**
 * 
 */
package com.crs.flipkart.business;

import com.crs.flipkart.bean.CourseCatalog;
import com.crs.flipkart.bean.SemesterRegistration;

/**
 * @author Abhinav
 *
 */

 /*Interface containing methods for Semester Registered of a student 
  *by adding ,droping and showing courses available for selection .
  */
public interface SemesterRegistrationServiceInterface {
	public boolean addCourse(SemesterRegistration semesterRegistration);
	
	public void dropCourse(SemesterRegistration semesterRegistration);
	
	public void showCourse();
}