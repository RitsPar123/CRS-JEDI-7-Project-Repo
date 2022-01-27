/**
 * 
 */
package com.crs.flipkart.business;

import com.crs.flipkart.bean.Notification;

/**
 * @author Abhinav
 *
 */

public interface NotificationServiceInterface {
	/* method to send Notification message to student with studentId*/
	public boolean sendNotification(String studentId, String message);
}
