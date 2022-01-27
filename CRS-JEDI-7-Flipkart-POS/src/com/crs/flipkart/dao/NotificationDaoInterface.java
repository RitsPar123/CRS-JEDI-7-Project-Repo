/**
 * 
 */
package com.crs.flipkart.dao;

/**
 * @author Abhinav
 *
 */
public interface NotificationDaoInterface {

	/**
	 * Method to insert a notification to DB using SQL commands
	 * @param studentId
	 * @param message
	 * @return true if successful / false if failure
	 */
	public boolean sendNotification(String studentId, String message);

}
