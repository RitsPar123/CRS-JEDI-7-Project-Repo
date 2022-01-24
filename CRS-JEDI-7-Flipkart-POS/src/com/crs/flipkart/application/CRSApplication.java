/**
 * 
 */
package com.crs.flipkart.application;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.CourseCatalog;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.bean.User;
import com.crs.flipkart.business.CourseCatalogService;
import com.crs.flipkart.business.CourseCatalogServiceInterface;
import com.crs.flipkart.business.UserService;
import com.crs.flipkart.business.UserServiceInterface;

/**
 * @author harsh
 *
 */
public class CRSApplication {

	/**
	 * @param args
	 */
	static CourseCatalog courseCatalog = new CourseCatalog();
	static StudentApplication studentApplication = new StudentApplication();
	static Scanner sc = new Scanner(System.in);
	static Map <String,Student> studentMap =new HashMap<String,Student>() ;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// To be removed when admin is added.
		CourseCatalogServiceInterface courseCatalogService = new CourseCatalogService();
		courseCatalogService.addCourse(courseCatalog, new Course(4, "English", 100, "Amit Balyan"));
		courseCatalogService.addCourse(courseCatalog, new Course(4, "Data structures", 101, "Kunal"));
		courseCatalogService.addCourse(courseCatalog, new Course(4, "Operating System", 102, "Priya"));
		courseCatalogService.addCourse(courseCatalog, new Course(4, "Embedded systems", 103, "Kalyan"));
		courseCatalogService.addCourse(courseCatalog, new Course(4, "Physics", 104, "Krishna"));
		courseCatalogService.addCourse(courseCatalog, new Course(4, "Maths", 105, "Harsh"));
		courseCatalogService.addCourse(courseCatalog, new Course(4, "Chemistry", 106, "Advait"));
		courseCatalogService.addCourse(courseCatalog, new Course(4, "Biology", 107, "Hardik"));

		Scanner sc = new Scanner(System.in);
		menu();
		int userInput = sc.nextInt();
		while (userInput != 4) {
			switch (userInput) {
				case 1:
					// login
					CRSApplication.loginUser();
					break;
				case 2:
					// student registration
					CRSApplication.registerStudent();
					break;
				default:
					System.out.println("Invalid Input");
			}
			menu();
			userInput = sc.nextInt();
		}
	}

	public static void menu() {
		System.out.println("----------Welcome to Course Management System---------");
		System.out.println("1. Login");
		System.out.println("2. Student Registration");
		System.out.println("3. Exit");
		System.out.println("Enter user input");
	}

	public static void registerStudent() {

		System.out.println("Enter Id:");
		String id = sc.next();

		System.out.println("Enter Password:");
		String password = sc.next();

		Student newapplication = new Student(id, password);

		studentMap.put(id,newapplication );


	}

	public static void loginUser() {
		String id, password;

		System.out.println("-----------------Login Menu------------------");
		System.out.println("Enter id ");

		id = sc.next();
		System.out.println("Enter password");
		password = sc.next();
		Boolean userapproval = false;
		
		User u = new User(id, password, 1);

		UserServiceInterface c = new UserService();
		if (c.userLogin(u)) {
			switch (u.getRole()) {
				// Student
				case 1: {
					
					if(studentMap.containsKey(id)==true && password.equals(studentMap.get(id).getPassword()))
					{
						userapproval=true;
						
					}
					
					if (userapproval == false) {
						System.out.println("Student Not registered or wrong password.");
						return;
					}
					
					
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
		}
	}

}
