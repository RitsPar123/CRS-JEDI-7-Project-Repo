/**
 * 
 */
package com.crs.flipkart.business;

import com.crs.flipkart.bean.Notification;
import com.crs.flipkart.bean.Payment;
import com.crs.flipkart.dao.NotificationDaoInterface;
import com.crs.flipkart.dao.NotificationDaoOperation;

/**
 * @author harsh
 *
 */

 /*
  *The NotificationService class is used to send notification
  */
public class NotificationService implements NotificationServiceInterface {
	NotificationDaoInterface notificationDaoOp = new NotificationDaoOperation();
	
	/*
	 *Method sends notification 
	 * @param studentId:id of the student
	 * @param message : notification message to be send;
	 */
	public boolean sendNotification(String studentId,String message) {		
		return notificationDaoOp.sendNotification(studentId,message);	
	}
	
}
