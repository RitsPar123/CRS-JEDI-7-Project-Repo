package com.crs.flipkart.business;

import com.crs.flipkart.business.ReportCardService;
import com.crs.flipkart.dao.PaymentDaoOperations;
import com.crs.flipkart.dao.RegisteredCoursesDaoInterface;
import com.crs.flipkart.dao.RegisteredCoursesDaoOperation;
import com.crs.flipkart.dao.NotificationDaoInterface;
import com.crs.flipkart.dao.NotificationDaoOperation;
import com.crs.flipkart.dao.PaymentDaoInterface;
import com.crs.flipkart.dao.RegisteredCoursesDaoInterface;
import com.crs.flipkart.dao.RegisteredCoursesDaoOperation;
import com.crs.flipkart.dao.StudentDaoInterface;
import com.crs.flipkart.dao.StudentDaoOperation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.crs.flipkart.bean.CourseCatalog;
import com.crs.flipkart.bean.Notification;
import java.util.Scanner;
import java.util.UUID;

import org.apache.log4j.Logger;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Payment;
import com.crs.flipkart.bean.RegisteredCourses;
import com.crs.flipkart.bean.ReportCard;
import com.crs.flipkart.bean.SemesterRegistration;
import com.crs.flipkart.bean.Student;

public class StudentService implements StudentServiceInterface{
	
	
	private static Logger logger = Logger.getLogger(StudentService.class);
	StudentDaoInterface StudentDaoInterface = new StudentDaoOperation(); 
	RegisteredCoursesDaoInterface registeredCoursesDaoInterface = new RegisteredCoursesDaoOperation();
	NotificationDaoInterface notificationDaoInterface = new NotificationDaoOperation();
	NotificationServiceInterface notificationService = new NotificationService();
	PaymentServiceInterface paymentInterface = new PaymentService();
	AdminServiceInterface adminInterface = new AdminService();
	
	Scanner sc = new Scanner(System.in);
	

	/*
	 * Method lets student sign up into the CRS system
     * @param  id: id of student
	 * @param  password : password of login
	 * @param  branch : branch of the student
	 * @param  name : name of the student
	 * @param role : signifies status in student table
	 */
	public String signup(String id,String password,String branch,String name,int role) {
		String studentId = null;
		
		Student newStudent = new Student();
		newStudent.setId(id);
		newStudent.setPassword(password);
		newStudent.setBranch(branch);
		newStudent.setApproved(false);
		newStudent.setRegistered(false);
		newStudent.setReportApproved(false);
		newStudent.setUserName(name);
		newStudent.setRole(1);
		
		studentId = StudentDaoInterface.signup(newStudent);
		
		return studentId;
	}

	
	/** 
	 * Method to show and handle registeration related options
	 * @param studentId
	 */
	public void register(String studentId) {
		
		// Get registrationStatus and feepaid status
		
		StudentDaoInterface studentDaoInterface = new StudentDaoOperation();
		int registrationStatus = studentDaoInterface.getRegistrationStatus(studentId);
		
		RegisteredCoursesService registeredCoursesService = new RegisteredCoursesService();
		
		List<Course> approvedCourses = registeredCoursesService.getApprovedCourses(studentId);
		
		if(registrationStatus==1) { // Fee is paid 
			System.out.println("Registration Successfull");
			return;
		}
	
		if(approvedCourses.size() == 6) { // Choices are approved
			System.out.println("Courses Approved. Please pay the fees to complete the registration process!");
			return;
		}
		
		SemesterRegistrationService semesterRegistrationService = new SemesterRegistrationService();
		SemesterRegistration semesterRegistration = new SemesterRegistration(studentId);
		
		while (true) {
			System.out.println("Enter an option");
			System.out.println("1. Add course");
			System.out.println("2. Drop Course");
			System.out.println("3. Show selected courses");
			System.out.println("4. Show all available Courses");

			int option = sc.nextInt();
			switch (option) {
				case 1: 
					if(registeredCoursesService.getSelectedCourses(studentId).size() < 6) semesterRegistrationService.addCourse(semesterRegistration);
					break;
				case 2:
					semesterRegistrationService.dropCourse(semesterRegistration);
					break;
				case 3: 
					semesterRegistrationService.showSelectedCourses(semesterRegistration);
					break;
				case 4:
					semesterRegistrationService.showCourse();
					break;
			}
			System.out.println("Are you done with selecting the courses? Y N");
			String selected = sc.next();
			if (selected.charAt(0) == 'Y')
				break;
		}

	}

	
	/**
	 * Method to view report card of student 
	 * @param id : Id of the student
	 */
	public void viewReportCard(String id) {
		 Student stud = new Student();
         stud = adminInterface.viewStudentData(id);
         
         System.out.println("Details are  ->");
         System.out.println("Id -> " + stud.getId() + " Name -> " + stud.getUserName() + " Branch -> " + stud.getBranch());
         
         if(!stud.isReportApproved()) {
        	 logger.debug("Report card generation is not approved");
        	 return;
         }
         
             List<RegisteredCourses> registeredCourses = adminInterface.activateGradeCard(id);
             
             if(stud.isReportApproved()) {
             for(RegisteredCourses course:registeredCourses) {
             	System.out.println("CourseId -> " + course.getCourseId() + " Grade ->  " + course.getGrade());
             	
             }
             }
         	System.out.println("Student Report Card");
	}

	
	/** 
	 * Method to view courses registered by student
	 * @param id : StudentId
	 */
	public void viewRegisteredCourses(String id) {
		
		int isRegistered = StudentDaoInterface.getRegistrationStatus(id);
		
		if(isRegistered == 0) {
			logger.debug("Registration in progress or incomplete!");
			return;
		}
		
		// Print RegisteredCourses
		List<Course> courses = registeredCoursesDaoInterface.getApprovedCoursesById(id);
		
		courses.forEach(course->{System.out.println("CourseId : " + course.getCourseId());});
//		for(Course course: courses) {
//			System.out.println("CourseId : " + course.getCourseId());
//		}
		
		System.out.println("--------------------------------------------------");
	}


	
	/** 
	 * Method to show notifications for a student
	 * @param studentId
	 */
	public void showNotifications(String studentId) {
		// TODO: Print all the messages of the student
		logger.info("Fetching Notification");
		notificationDaoInterface.getNoti(studentId);
	} 
	
	
	
}
