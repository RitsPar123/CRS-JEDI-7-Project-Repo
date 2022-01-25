/**
 * 
 */
package com.crs.flipkart.application;

import java.util.Scanner;

import com.crs.flipkart.business.ProfessorService;

/**
 * @author harsh
 *
 */
public class ProfessorApplication {
	
public void professorLoggedIn(String id) {
		
		ProfessorService professorService=new ProfessorService();
		
		while(true) {
			System.out.println("1. Select Courses");//Selecting courses for Professor
			System.out.println("2. View Registered Students");
			System.out.println("3. Add Grades");
			System.out.println("4. Show Courses");

			System.out.println("Enter your option");
			Scanner sc = new Scanner(System.in);
			
			int option = sc.nextInt();
			switch (option) {
				case 1:
					System.out.println("Enter course id");
					String courseid=sc.next();
					
					System.out.println("Enter course name");
					String coursename=sc.next();
					
					professorService.selectCourse(id ,courseid,coursename);
					//Status of allotment to be added whether alloted or not.
					break;
				case 2:
					professorService.viewRegisteredCourses(id);
					break;
				case 3:
					System.out.println("Enter  course Id");
					String courseId=sc.next();
					
					System.out.println("Enter student id");
					String studentId=sc.next();
					
					System.out.println("Enter  grade");
					int grade=sc.nextInt();
				
					
					professorService.addGrades(courseId,studentId,grade);
					//Show successful grade allotment
					break;
				 case 4:
					 professorService.showCourses();
					 //shows available courses that can be picked
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
