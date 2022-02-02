/**
 * 
 */
package com.crs.flipkart.business;

import java.util.List;

import com.crs.flipkart.bean.Notification;

/**
 * @author Abhinav
 *
 */

public interface NotificationServiceInterface {
	/* method to send Notification message to student with studentId*/
	public boolean sendNotification(String studentId, String message);

	public List<Notification> showNotifications(String id);
}
