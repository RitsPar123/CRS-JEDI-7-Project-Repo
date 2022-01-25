/**
 * 
 */
package com.crs.flipkart.application;

import java.util.Scanner;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.business.AdminService;
import com.crs.flipkart.business.AdminServiceInterface;

/**
 * @author harsh
 *
 */
public class AdminApplication {
	
	AdminServiceInterface adminInterface = new AdminService();
	Scanner sc = new Scanner(System.in);
	public void showMenu() {
		
		System.out.println("\n----------------Admin Menu----------------\n");
		
		CreateMenu();
		
		int userInput = sc.nextInt();
		
        while (userInput != 4) {
            switch (userInput) {
                case 1:
                    addCourse();
                    break;
                case 2:
                    //delete Course
                    deleteCourse();
                    break;
                case 3:
                	// update Password
                    CRSApplication.updatePassword();
                    break;
                default:
                    System.out.println("Invalid Input");
            }
            CreateMenu();
            userInput = sc.nextInt();
        }
		
	}
	
	 public void CreateMenu() {
			System.out.println("1  Add Course");
			System.out.println("2  Delete Course");
			System.out.println("3  Add Professor");
			System.out.println("4  Delete Professor");
			System.out.println("5  Approve Student Registration");
			System.out.println("6  Approve Student Semester Registration");
			System.out.println("7  Activate Grade Card");
			System.out.println("8  View Students Data");
			System.out.println("7  View All Courses");
			System.out.println("Student Course Allocation");

	 }
	 
	 public void addCourse() {
		 System.out.println("Enter Course Code");
		 String courseId = sc.next();
		 
		 System.out.println("Enter Course Name");
		 String courseName = sc.next();
		 
		 Course course = new Course(10,courseName,courseId,"aaaa");
		 
		 boolean added = false;
		 added = adminInterface.addCourse(course);
		 System.out.println(added);
		 return;
	 }
	 
	 public void deleteCourse() {
		 
	 }
}
