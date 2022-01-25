/**
 * 
 */
package com.crs.flipkart.application;

import java.util.Scanner;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Professor;
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
                	// add Professor
                    addProfessor();
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
	 }
	 
	 public void deleteCourse() {
		 System.out.println("Enter Course Code");
		 String courseId = sc.next();
		 
		 
		 boolean deleted = false;
		 deleted = adminInterface.deleteCourse(courseId);
		 System.out.println(deleted);
	 }
	 
	 public void addProfessor() {
		    System.out.println("Enter details of the Professor to be added: ");

		    System.out.println("Enter ProfessorId - ");
	        String id = sc.next();

	        System.out.println("Enter Department - ");
	        String department = sc.next();
	        
	        Professor professor = new Professor();
	        
	        professor.setDepartment(department);
	        professor.setId(id);
	        
	        boolean isProfessorAdded = adminInterface.addProfessor(professor);

	        if (isProfessorAdded) {
	        	System.out.println("Professor created successfully.");
	        }
	 }
}
