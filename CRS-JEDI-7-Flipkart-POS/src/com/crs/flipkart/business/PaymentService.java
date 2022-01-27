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
	NotificationServiceInterface notificationService = new NotificationService();
	PaymentDaoInterface paymentDao = new PaymentDaoOperations();
	Scanner sc = new Scanner(System.in);
	RegisteredCoursesServiceInterface registerCourse = new RegisteredCoursesService();
	
	@Override
	public void showMenu(String StudentId) {
		// TODO Auto-generated method stub
		
			int isRegister = registerCourse.getStatus(StudentId);
			
			if(isRegister ==  0) {
				System.out.println("Your Course Allocation Registration is still pending\n");
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
		String paymentId;
		System.out.println("Enter Your Account Number for further Confirmation and Notification");
		
		paymentId = sc.next();
		
		double amount = 1000;
		
		Payment payment = new Payment(studentId,paymentId,"Online",amount,"77777",true);
		boolean isPaid = paymentDao.payFees(payment);
		if(isPaid) {
			String message = "Fees Has been paid with Account number  -> " + paymentId;
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
		String paymentId;
		System.out.println("Enter Your ReceiptId for further Confirmation and Notification");
		
		paymentId = sc.next();
		
		double amount = 1000;
		
		Payment payment = new Payment(studentId,paymentId,"Offline",amount,"77777",true);
		boolean isPaid = paymentDao.payFees(payment);
		if(isPaid) {
			String message = "Fees Has been paid with RefrenceId  -> " + paymentId;
			registerCourse.updateStatus(studentId);
			notificationService.sendNotification(studentId,message);
			System.out.println(message);
			return;
		}else {
				System.out.println("Fees Has Not Been Paid");
			}
	}
}
