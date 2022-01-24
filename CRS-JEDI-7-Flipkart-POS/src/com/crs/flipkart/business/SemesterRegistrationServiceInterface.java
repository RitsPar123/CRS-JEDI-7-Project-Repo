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
public interface SemesterRegistrationServiceInterface {
	public void addCourse(SemesterRegistration semesterRegistration);
	
	public void dropCourse(SemesterRegistration semesterRegistration);
	
	public void showCourse(CourseCatalog courseCatalog);
}