/**
 *
 */
package com.crs.flipkart.application;

import java.util.Scanner;

import com.crs.flipkart.bean.CourseCatalog;
import com.crs.flipkart.business.StudentServiceInterface;

/**
 * @author harsh
 *
 */

public class StudentApplication {
	public void studentLoggedin(String id, CourseCatalog courseCatalog) {
		//StudentServiceInterface studentService = new StudentService();

		while(true) {
			System.out.println("1. Registration");
			System.out.println("2. View Report Card");
			System.out.println("3. View Registered Courses");
			System.out.println("4. Show Notifications");
			System.out.println("5. Pay Fees");
			System.out.println("Enter your option");
			Scanner sc = new Scanner(System.in);
			int option = sc.nextInt();
			switch (option) {
				case 1:
					//studentService.register(id, courseCatalog);
					break;
				case 2:
					//studentService.viewReportCard(id);
					break;
				case 3:
					//studentService.viewRegisteredCourses(id);
					break;
				 case 4:
					// studentService.showNotifications();
				case 5:
					//studentService.payFees(id);
					break;
				default:
					System.out.println("Enter valid option");
			}
			System.out.println("Do you want to logout? Y N");
			//char c = sc.nextLine().charAt(0);
			//if(c == 'Y') break;
		}
	}
}
