package com.crs.flipkart.business;

import com.crs.flipkart.business.ReportCardService;
import com.crs.flipkart.dao.StudentDaoInterface;
import com.crs.flipkart.dao.StudentDaoOperation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.crs.flipkart.bean.CourseCatalog;
import com.crs.flipkart.bean.Notification;
import com.crs.flipkart.bean.OfflinePayment;
import java.util.Scanner;
import java.util.UUID;
import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.OfflinePayment;
import com.crs.flipkart.bean.OnlinePayment;
import com.crs.flipkart.bean.Payment;
import com.crs.flipkart.bean.RegisteredCourses;
import com.crs.flipkart.bean.ReportCard;
import com.crs.flipkart.bean.SemesterRegistration;
import com.crs.flipkart.bean.Student;

public class StudentService implements StudentServiceInterface{
	
	StudentDaoInterface StudentDaoInterface = new StudentDaoOperation(); 
	
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
	

	
}
