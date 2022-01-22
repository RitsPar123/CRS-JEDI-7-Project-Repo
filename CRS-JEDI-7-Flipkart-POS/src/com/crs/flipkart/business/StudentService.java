package com.crs.flipkart.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.CourseCatalog;
import com.crs.flipkart.bean.RegisteredCourses;
import com.crs.flipkart.bean.ReportCard;
import com.crs.flipkart.bean.SemesterRegistration;

public class StudentService {
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

	public void viewReportCard() {
		// RegisteredCourses -> Report card
		// Print
	}

	public void viewRegisteredCourses(String id) {
		// Print RegisteredCourses
		RegisteredCourses r = null;
		// Find registerdCourses
		if (r == null) {
			System.out.println("Sorry! Registration Pending");
		} else {
			System.out.println("Registered courses are: ");
			for (Course c : r.getSelectedCourses()) {
				System.out.println("CourseName: " + c.getCourseName() + " Course Id: " + c.getCourseId());
			}
			System.out.println("-----------------------------------");
		}
	}

	public void payFees() {

	}

	public void showNotification() {

	}

}
