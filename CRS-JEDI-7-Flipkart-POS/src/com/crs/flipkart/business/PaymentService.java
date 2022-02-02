/**
 * 
 */
package com.crs.flipkart.business;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.crs.flipkart.bean.Payment;
import com.crs.flipkart.dao.PaymentDaoInterface;
import com.crs.flipkart.dao.PaymentDaoOperations;

/**
 * @author Abhinav
 *
 */
public class PaymentService implements PaymentServiceInterface {
	
	private static Logger logger = Logger.getLogger(PaymentService.class);
	NotificationServiceInterface notificationService = new NotificationService();
	PaymentDaoInterface paymentDao = new PaymentDaoOperations();
	Scanner sc = new Scanner(System.in);
	RegisteredCoursesServiceInterface registerCourse = new RegisteredCoursesService();
	
	/*
	 *Method gives student various payment options
	 * @param StudentId : Id of the Student
	 */
	@Override
	public void showMenu(String StudentId) {
		// TODO Auto-generated method stub
		    logger.info("Displaying menu");
			int isRegister = registerCourse.getStatus(StudentId);
			
			if(isRegister ==  0) {
				logger.info("Your Course Allocation Registration is still pending");
				return;
			}
			
			if(paymentDao.isPaid(StudentId)) {
				logger.info("Fee has been paid already");
				return;
			}
		 	System.out.println("----------------Payment Options----------------\n");
		 	System.out.println("  Amount to be Paid is 1000");

		 	System.out.println("1  Online Payment");
	        System.out.println("2  Offline Payment");
	        	
	        System.out.println("\nEnter Your Choice");
	        	int userInput = sc.nextInt();
	        	
	            switch (userInput) {
	                case 1:
	                    onlinePayment(StudentId);
	                    break;
	                case 2:
	                    // delete Course
	                    offlinePayment(StudentId);
	                    break;

	                default:
	                    System.out.println("Invalid Input");
	            }
	        }

	private void onlinePayment(String studentId) {
		// TODO Auto-generated method stub
		logger.info("Online-payment method");
		String paymentId;
		System.out.println("Enter Your Account Number for further Confirmation and Notification");
		
		paymentId = sc.next();
		
		double amount = 1000;
		
		Payment payment = new Payment(studentId,paymentId,"Online",amount,"77777",true);
		boolean isPaid = paymentDao.payFees(payment);
		if(isPaid) {
			String message = "Fees Has been paid online";
			registerCourse.updateStatus(studentId);
			notificationService.sendNotification(studentId,message);
			System.out.println(message);
			return;
		}else {
			System.out.println("Fees Ha Not Been Paid");
		}
		
	}

	private void offlinePayment(String studentId) {
		// TODO Auto-generated method stub
		logger.info("Offline payment mehthod");
		String paymentId;
		System.out.println("Enter Your ReceiptId for further Confirmation and Notification");
		
		paymentId = sc.next();
		
		double amount = 1000;
		
		Payment payment = new Payment(studentId,paymentId,"Offline",amount,"77777",true);
		boolean isPaid = paymentDao.payFees(payment);
		if(isPaid) {
			String message = "Fees Has been paid offline";
			registerCourse.updateStatus(studentId);
			notificationService.sendNotification(studentId,message);
			System.out.println(message);
			return;
		}else {
				System.out.println("Fees Has Not Been Paid");
			}
	}
}
