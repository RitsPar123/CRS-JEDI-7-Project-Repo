/**
 * 
 */
package com.crs.flipkart.business;

import com.crs.flipkart.bean.Notification;
import com.crs.flipkart.bean.Payment;

/**
 * @author harsh
 *
 */
public class NotificationService {
	public Notification generatePaymentNotification(Payment p) {
		// Send notification message to studentId
		
		Notification notification = new Notification();
		notification.setStudentId(p.getStudentId());
		notification.setMessage("Payment of " + p.getAmount() + " successfull with PaymentId " + p.getPaymentId() + " ! ");
		
		return notification;
		
	}
	
	public Notification generateRegistrationNotification(String studentId) {
		Notification notification = new Notification();
		
		notification.setStudentId(studentId); 
		notification.setMessage("Registration for id " + studentId + " successfull.");
		
		return notification;
		
	}
	
}
