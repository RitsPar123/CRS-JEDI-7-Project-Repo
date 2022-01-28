/**
 * 
 */
package com.crs.flipkart.business;

import com.crs.flipkart.bean.CourseCatalog;
import com.crs.flipkart.bean.Payment;

/**
 * @author hardik.kothari
 *
 */

 /*Interface containing method for student signup */
public interface StudentServiceInterface {
	
		public String signup(String id,String password,String branch,String name,int role);

		public void viewRegisteredCourses(String id);

		public void register(String id);

}