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
public class NotificationService implements NotificationServiceInterface {
	NotificationDaoInterface notificationDaoOp = new NotificationDaoOperation();
	
	public boolean sendNotification(String studentId,String message) {		
		return notificationDaoOp.sendNotification(studentId,message);	
	}
	
}
