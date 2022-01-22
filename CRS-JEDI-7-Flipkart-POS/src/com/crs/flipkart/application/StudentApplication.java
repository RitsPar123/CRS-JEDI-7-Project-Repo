/**
 * 
 */
package com.crs.flipkart.application;

import java.util.Scanner;

import com.crs.flipkart.bean.Student;
import com.crs.flipkart.business.StudentService;

/**
 * @author harsh
 *
 */
public class StudentApplication {
	public void studentLoggedin(String id) {
		Student student = new Student(id);
		StudentService studentService = new StudentService();
		System.out.println("1. Registration");
		System.out.println("2. View Report Card");
		System.out.println("3. View Registered Courses");
		System.out.println("4. Show Notifications");
		System.out.println("5. Pay Fees")
		System.out.println("Enter your option"); 
		Scanner sc = new Scanner(System.in);
		int option = sc.nextInt();
		
		switch (option) { 
			case 1: 
				// To implement
				studentService.register();
				break;
			case 2:
				studentService.viewReportCard();
				break;
			case 3:
				studentService.viewRegisteredCourses(id);
				break;
			case 4: 
				studentService.showNotifications();
			default:
		}
	}
}
