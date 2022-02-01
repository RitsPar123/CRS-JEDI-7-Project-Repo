/**
 * 
 */
package com.crs.flipkart.application;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.apache.log4j.Logger;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.bean.Professor;
import com.crs.flipkart.bean.RegisteredCourses;
import com.crs.flipkart.business.AdminService;
import com.crs.flipkart.business.AdminServiceInterface;
import com.crs.flipkart.business.NotificationService;
import com.crs.flipkart.business.NotificationServiceInterface;
import com.crs.flipkart.dao.AdminDaoOperation;
import com.crs.flipkart.exception.CourseFoundException;
import com.crs.flipkart.exception.CourseNotAddedException;
import com.crs.flipkart.exception.CourseNotDeletedException;
import com.crs.flipkart.exception.CourseNotFoundException;
import com.crs.flipkart.exception.ProfessorNotAddedException;
import com.crs.flipkart.exception.StudentNotApprovedException;
import com.crs.flipkart.exception.StudentNotFoundForApprovalException;
import com.crs.flipkart.exception.UserIdAlreadyInUseException;
import com.crs.flipkart.exception.UserNotAddedException;

/**
 * @author harsh
 *
 */
public class AdminApplication {
	
	
    AdminServiceInterface adminInterface = new AdminService();
    static NotificationServiceInterface notificationService = new NotificationService();
    Scanner sc = new Scanner(System.in);
    private static Logger logger = Logger.getLogger(AdminDaoOperation.class);

    public void showMenu(){

        System.out.println("----------------Admin Menu----------------\n");

        CreateMenu();
        
        System.out.println("\nEnter Your Choice");
        int userInput = sc.nextInt();

        while (userInput != 11) {
        	
            switch (userInput) {
                case 1:	
                    addCourse(); 
                    break;
                case 2:
                	deleteCourse();
                	
                    break;
                case 3:
                	addProfessor();
                	
                    break;
                case 4:
                    // view Pending Approvals
                    viewPendingApproval();
                    break;
                case 5:
                    // Approve Registration
                	try {
                    approveRegistration();
                    }
                	catch(StudentNotApprovedException e) {
                		logger.error("Exception "+e.getMessage());
                	}
                	System.out.println("************************************");
                    break;

                case 6:
                    // View Courses
                    viewCourses();
                    break;
                case 7:
                    // Allot Course
                    studentCourseAllot();
                    break;
                case 8:
                    // View Student Data
                    activateGradeCard();
                    System.out.println("************************************");
                    break;

                default:
                    System.out.println("Invalid Input");
            }
            CreateMenu();
            System.out.println("\nEnter Your Choice");
            userInput = sc.nextInt();
        }

    }


	private void CreateMenu() {
        System.out.println("1  Add Course");
        System.out.println("2  Delete Course");
        System.out.println("3  Add Professor");
        System.out.println("4  View Pending Approval Registration");
        System.out.println("5  Approve Student SignUp Registration");
        System.out.println("6  View All Courses");
        System.out.println("7  Student Course Allocation");
        System.out.println("8  Activate Grade Card");

    }

    private void addCourse(){
        System.out.println("Enter Course Code");
        String courseId = sc.next();

        System.out.println("Enter Course Name");
        String courseName = sc.next();

        Course course = new Course(10, courseName, courseId, "aaaa");

        boolean added = false;
        try {
			adminInterface.addCourse(course);
		} catch (CourseFoundException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
		}

    }

    public void deleteCourse(){
        System.out.print("Enter Course Code : ");
        String courseId = sc.next();
        System.out.println();
        boolean deleted = false;
        try {
			adminInterface.deleteCourse(courseId);
		} catch (CourseNotFoundException | CourseNotDeletedException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
		} 
    }

    private void addProfessor(){
        logger.info("Enter details of the Professor to be added: ");

        logger.info("Enter ProfessorId: ");
        String id = sc.next();
        
        logger.info("Enter Department: ");
        String department = sc.next();
      
        
        logger.info("Enter Name: ");
        String name = sc.next();
        
        
        System.out.print("Enter Password: ");
        String password = sc.next();
        System.out.println();
        
        Professor professor = new Professor();

        professor.setDepartment(department);
        professor.setId(id);

        boolean isProfessorAdded;
		try {
			adminInterface.addProfessor(professor);
			try {
				boolean addUser = adminInterface.addUser(id,password,name);
			} catch (UserNotAddedException e) {
				// TODO Auto-generated catch block
				logger.error(e.getMessage());
			}
		} catch (UserIdAlreadyInUseException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
		} catch (ProfessorNotAddedException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
		}
        

       
    }

    private void approveRegistration() throws StudentNotApprovedException{
        // TODO Auto-generated method stub
        System.out.print("Enter Student's ID: ");
        String studentUserId = sc.next();

        boolean isApprove;
		try {
			adminInterface.approveStudent(studentUserId);
			
			notificationService.sendNotification(studentUserId,"Student Registration is being Approved");
            logger.info("Student Registration is being Approved\n");
		} catch (StudentNotFoundForApprovalException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
		}
    }

    private void viewPendingApproval() {

        List<Student> studentList = adminInterface.viewPendingApproval();
        if(studentList.size()!=0) {
        System.out.println("Student Details\n");
        for (Student s : studentList) {
            System.out.println("Id -> " + s.getId() + " Name -> " + s.getUserName() + " Branch ->  " + s.getBranch());
        }
        } 
        else 
        	logger.info("No pending Approval Requests");
       
    }

    private void viewCourses() {
        // TODO Auto-generated method stub
        List<Course> courseList = adminInterface.viewCourse();
        if(courseList!=null && courseList.size()>0) {
        System.out.println("Course Details\n");
        for (Course c : courseList) {
            System.out.println(
                    " Id -> " + c.getCourseId() + " Name -> " + c.getCourseName() + "  Seat Left -> " + c.getCount());
        }
        } 
        
    }
    
	private void activateGradeCard() {
		// TODO Auto-generated method stub
		System.out.print("Enter Student's ID :");
        String studentId = sc.next();
        
    	
            Student stud = new Student();
            stud = adminInterface.viewStudentData(studentId);
            
            System.out.println("Details are  ->");
            System.out.println("Id -> " + stud.getId() + " Name -> " + stud.getUserName() + " Branch -> " + stud.getBranch());

            if(!stud.isReportApproved()) {
                List<RegisteredCourses> registeredCourses = adminInterface.activateGradeCard(studentId);
                int count = 0;
                
                for(RegisteredCourses course:registeredCourses) {
                	System.out.println("CourseId -> " + course.getCourseId() + " Grade " + course.getGrade());
                	count++;
                }
            
                	adminInterface.approveStudentRegistration(studentId);
                	System.out.println("Student Report is Generated");

                }

	}
	
    private void studentCourseAllot() {
		// TODO Auto-generated method stub
    	
    	System.out.print("Enter Student's ID: ");
        String studentId = sc.next();
        Set<String> courseList = adminInterface.viewSelectedCourse(studentId);  
        
        String message;
        boolean status = true;
        int count = 0;
        
        String s1=null,s2=null;

	       	logger.info("\nStudent Has Been Registered");
	       	adminInterface.updateRegistered(studentId,s1,s2);
	       	message = "Registered";
	       	notificationService.sendNotification(studentId,message);

	}
	
}
