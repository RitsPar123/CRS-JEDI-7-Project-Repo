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
	 * Inserting a notification to DB using SQL commands
	 * @param studentId
	 * @param message
	 * @return true if successful / false if failure
	 */
	public boolean sendNotification(String studentId, String message);

}
