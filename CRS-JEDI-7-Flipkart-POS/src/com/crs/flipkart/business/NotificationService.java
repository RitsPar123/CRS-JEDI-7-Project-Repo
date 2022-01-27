/**
 * 
 */
package com.crs.flipkart.business;

import java.util.List;

import com.crs.flipkart.bean.Course;
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

	@Override
	public void showNotifications(String id) {
		// TODO Auto-generated method stub
		List<Notification> notification = notificationDaoOp.getNoti(id);
		System.out.println("Notifications : ");
		for(Notification noti: notification) {
			System.out.println(noti.getMessage() + " ");
		}
		
		System.out.println("--------------------------------------------------");
	}
	}
