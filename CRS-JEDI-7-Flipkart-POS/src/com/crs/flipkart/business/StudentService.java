package com.crs.flipkart.business;

import com.crs.flipkart.bean.Course;
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
		} else {
			System.out.println("Registered courses are: ");
			for(Course c: r.getSelectedCourses()) {
				System.out.println("CourseName: "+ c.getCourseName() + " Course Id: "+c.getCourseId());
			}
			System.out.println("-----------------------------------");
		}
	}
	
	public void payFees() {
		
	}
	
	public void showNotification() {
		
	}
	
}
