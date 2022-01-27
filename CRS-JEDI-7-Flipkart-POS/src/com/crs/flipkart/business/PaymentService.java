/**
 * 
 */
package com.crs.flipkart.business;

import java.util.Scanner;

import com.crs.flipkart.bean.Payment;
import com.crs.flipkart.dao.PaymentDaoInterface;
import com.crs.flipkart.dao.PaymentDaoOperations;

/**
 * @author Abhinav
 *
 */
public class PaymentService implements PaymentServiceInterface {
	static NotificationServiceInterface notificationService = new NotificationService();
	PaymentDaoInterface paymentDao = new PaymentDaoOperations();
	Scanner sc = new Scanner(System.in);
	
	/*
	 *Method gives student various payment options
	 * @param StudentId : Id of the Student
	 */
	@Override
	public void showMenu(String StudentId) {
		// TODO Auto-generated method stub
		 	System.out.println("----------------Payment Options----------------\n");
		 	System.out.println("1  Amount to be Paid is 1000");

		 	System.out.println("1  Online Payment");
	        System.out.println("2  Offline Payment");

	        int userInput = sc.nextInt();
	        	
	        	System.out.println("\nEnter Your Choice");
	        	
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
		String paymentId;
		System.out.println("Enter Your Account Number for further Confirmation and Notification");
		
		paymentId = sc.next();
		
		double amount = 1000;
		
		Payment payment = new Payment(studentId,paymentId,"Online",amount,"77777",true);
		boolean isPaid = paymentDao.payFees(payment);
		if(isPaid) {
			String message = "Fees Has been paid with Account number" + paymentId;
			notificationService.sendNotification(studentId,message);
		}
		
	}

	private void offlinePayment(String studentId) {
		// TODO Auto-generated method stub
		String paymentId;
		System.out.println("Enter Your ReceiptId for further Confirmation and Notification");
		
		paymentId = sc.next();
		
		double amount = 1000;
		
		Payment payment = new Payment(studentId,paymentId,"Offline",amount,"77777",true);
		boolean isPaid = paymentDao.payFees(payment);
		if(isPaid) {
			String message = "Fees Has been paid with RefrenceId" + paymentId;
			notificationService.sendNotification(studentId,message);
		}
		
	}
}
