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
public interface StudentServiceInterface {
	
    	void register(String studentId, CourseCatalog courseCatalog);
    	void viewReportCard(String id);
    	void viewRegisteredCourses(String id);
    	void payFees(String id);
    	void showPaymentNotification(Payment pay);


}