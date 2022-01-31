/**
 * 
 */
package com.crs.flipkart.business;

import com.crs.flipkart.bean.CourseCatalog;
import com.crs.flipkart.bean.Payment;
import com.crs.flipkart.exception.StudentNotRegisteredException;

/**
 * @author hardik.kothari
 *
 */

 /*Interface containing method for student signup */
public interface StudentServiceInterface {
	
		public String signup(String id,String password,String branch,String name,int role) throws StudentNotRegisteredException;

		public void viewRegisteredCourses(String id);

		public void register(String id);

}