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
	public boolean sendNotification(String studentId, String message);
}
