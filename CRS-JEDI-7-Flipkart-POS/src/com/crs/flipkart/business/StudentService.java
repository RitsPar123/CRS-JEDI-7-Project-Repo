package com.crs.flipkart.business;

import com.crs.flipkart.business.ReportCardService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.crs.flipkart.bean.CourseCatalog;
import com.crs.flipkart.bean.Notification;
import com.crs.flipkart.bean.OfflinePayment;
import java.util.Scanner;
import java.util.UUID;
import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.OfflinePayment;
import com.crs.flipkart.bean.OnlinePayment;
import com.crs.flipkart.bean.Payment;
import com.crs.flipkart.bean.RegisteredCourses;
import com.crs.flipkart.bean.ReportCard;
import com.crs.flipkart.bean.SemesterRegistration;
import com.crs.flipkart.bean.Student;

public class StudentService implements StudentServiceInterface{
	List<Course> selectedCourses = new ArrayList<>();
	Scanner sc = new Scanner(System.in);

	public void register(String studentId, CourseCatalog courseCatalog) {
		SemesterRegistrationService semesterRegistrationService = new SemesterRegistrationService();
		SemesterRegistration semesterRegistration = new SemesterRegistration(studentId);
		while (true) {
			System.out.println("Enter an option");
			System.out.println("1. Add course");
			System.out.println("2. Drop Course");
			System.out.println("3. Show Courses");

			int option = sc.nextInt();
			switch (option) {
				case 1: {
					while (semesterRegistration.getCourses().size() != 6)
						semesterRegistrationService.addCourse(semesterRegistration);
				}
					break;
				case 2:
					semesterRegistrationService.dropCourse(semesterRegistration);
					break;
				case 3:
					semesterRegistrationService.showCourse(courseCatalog);
					break;
			}
			System.out.println("Are you done with selecting the courses? Y N");
			String selected = sc.next();
			if (selected.charAt(0) == 'Y')
				break;
		}

	}

	public void viewReportCard(String id) {
		// RegisteredCourses -> Report card
		// Print
		ReportCardService reportcardservice = new ReportCardService();
		reportcardservice.ViewReportCard(id);
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
			for (Course c : r.getSelectedCourses()) {
				System.out.println("CourseName: " + c.getCourseName() + " Course Id: " + c.getCourseId());
			}
			System.out.println("-----------------------------------");
		}
	}

	public void payFees(String id) {


		// add check for already paid fees


		Payment payment=new Payment();
		payment.setStudentId(id);
		payment.setDateOfTransaction(java.time.LocalDate.now().toString());
		payment.setPaymentId(UUID.randomUUID().toString());

		//fetch amount that needs to be paid
		payment.setAmount(1000);



		System.out.println("Choose mode of payment:");
		System.out.println("1. Online");
		System.out.println("2. Offline");

		Scanner sc = new Scanner(System.in);
		int option = sc.nextInt();



		switch(option) {
			case 1:

				OnlinePaymentServiceInterface ol= new OnlinePaymentService();
				OnlinePayment onlinePayment= ol.onlineMode();
				if(onlinePayment!=null) {
					payment.setStatus(true);
				}
				break;
			case 2:
				OfflinePaymentServiceInterface of= new OfflinePaymentService();
				OfflinePayment offlinePayment = of.offlineMode();
				if(offlinePayment!=null) {
					payment.setStatus(true);
				}
				break;

			default:
				System.out.println("Sorry you entered the wrong choice!!");
				payment.setStatus(false);
				break;

		}


		if(payment.getStatus()==true) {
			NotificationService notificationService = new NotificationService();
			
			Notification notification = notificationService.generatePaymentNotification(payment);
			// TODO: Push notification to DB for studentId
			
			notification = notificationService.generateRegistrationNotification(payment.getStudentId());
			// TODO: Push successfull notification to DB for studentId
		}

	}

	public void showNotifications() {
		// TODO: Print all the messages of the student
	}
	
}
