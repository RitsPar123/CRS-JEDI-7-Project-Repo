/**
 * 
 */
package com.crs.flipkart.business;

import java.util.List;

import org.apache.log4j.Logger;

import com.crs.flipkart.bean.Course;
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
	private static Logger logger = Logger.getLogger(NotificationService.class);
	
	
	
	/** 
	 * Method that sends notification 
	 * @param studentId : id of the student
	 * @param message : notification message to be send
	 * @return boolean
	 */
	public boolean sendNotification(String studentId,String message) {
		logger.info("Sending notification");
		return notificationDaoOp.sendNotification(studentId,message);	
	}

	
	/** 
	 * Method to show stored notifications
	 * @param id : id of the student
	 */
	@Override
	public List<Notification> showNotifications(String id) {
		// TODO Auto-generated method stub
		logger.info("Displaying notification ");
		List<Notification> notification = notificationDaoOp.getNoti(id);
		
		return notification;
	
		
	}
	}
