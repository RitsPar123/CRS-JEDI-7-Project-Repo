/**
 * 
 */
package com.crs.flipkart.business;

/**
 * @author Abhinav
 *
 */

 /* Interface to implement showMenu Method which is used by PaymentService class  */
public interface PaymentServiceInterface {

	void showMenu(String StudentId);
	public boolean onlinePayment(String studentId) throws Exception;
	public boolean offlinePayment(String studentId) throws Exception;

}
