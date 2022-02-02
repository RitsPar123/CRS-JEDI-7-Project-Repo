/**
 * 
 */
package com.crs.flipkart.dao;

import java.util.List;

import com.crs.flipkart.bean.Notification;

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

	public List<Notification> getNoti(String id);

}
