package com.crs.flipkart.business;

import java.util.Scanner;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.OfflinePayment;
import com.crs.flipkart.bean.Payment;
import com.crs.flipkart.bean.RegisteredCourses;
import com.crs.flipkart.bean.ReportCard;

public class StudentService {
	public void register() {
		
	}
	
	public void viewReportCard() {
		// RegisteredCourses -> Report card
		// Print
	}
	
	public void viewRegisteredCourses(String id) {
		// Print RegisteredCourses
		RegisteredCourses r = null;
		// Find registerdCourses 
		
		if(r==null) {
			System.out.println("Sorry! Registration Pending");
		} 
		else
		{
			System.out.println("Registered courses are: ");
			for(Course c: r.getSelectedCourses()) {
				System.out.println("CourseName: "+ c.getCourseName() + " Course Id: "+c.getCourseId());
			}
			System.out.println("-----------------------------------");
		}
	}
	
	public void payFees(String id) {
		
		
		//fetch fees to be paid
		// add check for already paid fees
		
		
		Payment pay=new Payment();
		pay.setDateOfTransaction(java.time.LocalDateTime.now().toString());
		
		//fetch amount that needs to be paid
		
		pay.setAmount(1);
		
		
		
		System.out.println("Choose mode of payment:");
		System.out.println("1. Online");
		System.out.println("2. Offline");
		
		Scanner sc = new Scanner(System.in);
		int option = sc.nextInt();
		
		
		
		switch(option) {
		case 1:
			
			OnlinePaymentService ol= new OnlinePaymentService();
			ol.onlineMode();
			break;
		case 2:
			OfflinePaymentService of= new OfflinePaymentService();
			OfflinePayment op = of.offlineMode();
			break;

		default:
			break;
			
			
		
		}
		//if payment done show notif
		showNotification(pay);
		
		
		
		
		
	}
	
	public void showNotification(Payment pay) {
		System.out.println("Payment of fees done. Payment Details:");
		System.out.println("PaymentID "+ pay.getPaymentId());
		System.out.println("Amount" + pay.getAmount());
		System.out.println("DateOfTransaction" + pay.getDateOfTransaction()+pay.get);
		 
	}
	
}
