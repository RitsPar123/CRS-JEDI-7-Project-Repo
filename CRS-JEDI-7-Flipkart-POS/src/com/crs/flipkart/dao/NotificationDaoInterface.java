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

	public boolean sendNotification(String studentId, String message);

	public List<Notification> getNoti(String id);

}
