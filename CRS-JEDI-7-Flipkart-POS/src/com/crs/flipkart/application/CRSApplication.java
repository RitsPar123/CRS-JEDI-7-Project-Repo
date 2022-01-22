/**
 * 
 */
package com.crs.flipkart.application;

import java.util.Scanner;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.CourseCatalog;
import com.crs.flipkart.bean.User;
import com.crs.flipkart.business.CourseCatalogService;
import com.crs.flipkart.business.UserService;

/**
 * @author harsh
 *
 */
public class CRSApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CourseCatalog courseCatalog = new CourseCatalog();
		// To be removed when admin is added.
		CourseCatalogService courseCatalogService = new CourseCatalogService();
		courseCatalogService.addCourse(courseCatalog, new Course(4, "English", 100, "Amit Balyan"));
		courseCatalogService.addCourse(courseCatalog, new Course(4, "Data structures", 101, "Kunal"));
		courseCatalogService.addCourse(courseCatalog, new Course(4, "Operating System", 102, "Priya"));
		courseCatalogService.addCourse(courseCatalog, new Course(4, "Embedded systems", 103, "Kalyan"));
		courseCatalogService.addCourse(courseCatalog, new Course(4, "Physics", 104, "Krishna"));
		courseCatalogService.addCourse(courseCatalog, new Course(4, "Maths", 105, "Harsh"));
		courseCatalogService.addCourse(courseCatalog, new Course(4, "Chemistry", 106, "Advait"));
		courseCatalogService.addCourse(courseCatalog, new Course(4, "Biology", 107, "Hardik"));

		while (true) {

			String id, password;
			System.out.println("Login Menu");
			System.out.println("Enter id ");
			Scanner sc = new Scanner(System.in);
			id = sc.next();
			System.out.println("Enter password");
			password = sc.next();

			User u = new User(id, password, 1);
			UserService c = new UserService();
			if (c.userLogin(u)) {
				while (true) {
					switch (u.getRole()) {
						// Student
						case 1: {
							StudentApplication studentApplication = new StudentApplication();
							studentApplication.studentLoggedin(u.getId(), courseCatalog);
						}
							break;
						case 2:
							// Professor
							break;
						case 3:
							// Admin
							break;
					}
					System.out.println("Want to logout? Y N");
					char ans = sc.next().charAt(0);
					if (ans == 'Y')
						break;
				}
			}

			System.out.println("Session ended");
			System.out.println("Do you want to end the program? Y N");
			char ans = sc.next().charAt(0);
			if (ans == 'Y')
				break;
		}

	}

}
