package com.crs.flipkart.business;

import com.crs.flipkart.business.ReportCardService;
import com.crs.flipkart.dao.PaymentDaoOperations;
import com.crs.flipkart.dao.RegisteredCoursesDaoInterface;
import com.crs.flipkart.dao.RegisteredCoursesDaoOperation;
import com.crs.flipkart.dao.PaymentDaoInterface;
import com.crs.flipkart.dao.StudentDaoInterface;
import com.crs.flipkart.dao.StudentDaoOperation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.crs.flipkart.bean.CourseCatalog;
import com.crs.flipkart.bean.Notification;
import java.util.Scanner;
import java.util.UUID;
import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Payment;
import com.crs.flipkart.bean.RegisteredCourses;
import com.crs.flipkart.bean.ReportCard;
import com.crs.flipkart.bean.SemesterRegistration;
import com.crs.flipkart.bean.Student;

public class StudentService implements StudentServiceInterface{
	
	StudentDaoInterface StudentDaoInterface = new StudentDaoOperation(); 
	RegisteredCoursesDaoInterface registeredCoursesDaoInterface = new RegisteredCoursesDaoOperation();
	
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
	
	public void viewRegisteredCourses(String id) {
		
		int isRegistered = StudentDaoInterface.getRegistrationStatus(id);
		
		if(isRegistered == 0) {
			System.out.println("Registration in progrees or incomplete!");
			return;
		}
		
		// Print RegisteredCourses
		List<Course> courses = registeredCoursesDaoInterface.getApprovedCoursesById(id);
		
		for(Course course: courses) {
			System.out.println("CourseId : " + course.getCourseId());
		}
		
		System.out.println("--------------------------------------------------");
	}

	
}
