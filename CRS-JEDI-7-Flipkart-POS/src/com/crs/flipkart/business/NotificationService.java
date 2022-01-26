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
	
	public Notification generatePaymentNotification(Payment p) {
		// Send notification message to studentId
		
		Notification notification = new Notification();
		notification.setStudentId(p.getStudentId());
		notification.setMessage("Payment of " + p.getAmount() + " successfull with PaymentId " + p.getPaymentId() + " ! ");
		
		return notification;
		
	}
	
	public boolean sendNotification(String studentId,String message) {		
		return notificationDaoOp.sendNotification(studentId,message);	
	}
	
}
