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
import com.crs.flipkart.exception.CourseNotAddedException;
import com.crs.flipkart.exception.CourseNotDeletedException;
import com.crs.flipkart.exception.ProfessorNotAddedException;
import com.crs.flipkart.exception.StudentNotApprovedException;

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
                	try {
                    addCourse(); 
                    }
                	catch(CourseNotAddedException e) {
                		logger.error("Exception "+e.getMessage());
                	}
                	 System.out.println("************************************");
                    break;
                case 2:
                    // delete Course
                	try {
                		deleteCourse();
                    }
                	catch(CourseNotDeletedException e) {
                		logger.error("Exception "+e.getMessage());
                	}
                	System.out.println("************************************");
                    break;
                case 3:
                    // add Professor
                	try {
                    addProfessor(); 
                    }
                	catch(ProfessorNotAddedException e) {
                		logger.error("Exception "+e.getMessage());
                	}
                	System.out.println("************************************");
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

    private void addCourse() throws CourseNotAddedException{
        System.out.println("Enter Course Code");
        String courseId = sc.next();

        System.out.println("Enter Course Name");
        String courseName = sc.next();

        Course course = new Course(10, courseName, courseId, "aaaa");

        boolean added = false;
        added = adminInterface.addCourse(course);
        
        if(added)
        	System.out.println("\n The Course Has Been Added\n");
        else 
        	throw new CourseNotAddedException(courseId);
        
    }

    public void deleteCourse() throws CourseNotDeletedException{
        System.out.print("Enter Course Code : ");
        String courseId = sc.next();
        System.out.println();
        boolean deleted = false;
        deleted = adminInterface.deleteCourse(courseId);

        if (deleted)
            System.out.println("Course is Deleted");
        else 
        	throw new CourseNotDeletedException(courseId);
    }

    private void addProfessor() throws ProfessorNotAddedException{
        System.out.println("Enter details of the Professor to be added: ");

        System.out.print("Enter ProfessorId: ");
        String id = sc.next();
        System.out.println();
        
        System.out.print("Enter Department: ");
        String department = sc.next();
        System.out.println();
        
        System.out.print("Enter Name: ");
        String name = sc.next();
        System.out.println();
        
        System.out.print("Enter Password: ");
        String password = sc.next();
        System.out.println();
        
        Professor professor = new Professor();

        professor.setDepartment(department);
        professor.setId(id);

        boolean isProfessorAdded = adminInterface.addProfessor(professor);
        boolean addUser = adminInterface.addUser(id,password,name);

        if (isProfessorAdded) 
            System.out.println("Professor created successfully.");
        else
        	throw new ProfessorNotAddedException(professor);
    }

    private void approveRegistration() throws StudentNotApprovedException{
        // TODO Auto-generated method stub
        System.out.print("Enter Student's ID: ");
        String studentUserId = sc.next();

        boolean isApprove = adminInterface.approveStudent(studentUserId);

        if (isApprove) {
        	notificationService.sendNotification(studentUserId,"Student Registration is being Approved");
            System.out.println("Student Registration is being Approved\n");
        } 
        else 
        	throw new StudentNotApprovedException(studentUserId);
    }

    private void viewPendingApproval() {

        List<Student> studentList = adminInterface.viewPendingApproval();
        if(studentList!=null && studentList.size()!=0) {
        System.out.println("Student Details\n");
        for (Student s : studentList) {
            System.out.println("Id -> " + s.getId() + " Name -> " + s.getUserName() + " Branch ->  " + s.getBranch());
        }
        } 
        else 
        	logger.info("No pending Approval Requests");
        System.out.println("************************************");
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
        
        logger.info("No courses found in course catalogue\n");
        System.out.println("************************************");
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
//
//	       for (String c : courseList) {
//	        		count++;
//	        		if(count>4) {
//	        			if(s1 == null) {
//	        				s1 = c;
//	        			}else {
//	        				s2 = c;
//	        			}
//	        		}
//	        }
	       	System.out.println("\nStudent Has Been Registered");
	       	adminInterface.updateRegistered(studentId,s1,s2);
	       	message = "Registered";
	       	notificationService.sendNotification(studentId,message);
        

        
//        if(count>2) {
//        	status = false;
//    		message = "Not Done";
//    		adminInterface.deleteEntry(studentId);
//    		adminInterface.updateCourse(courseList);
//    		notificationService.sendNotification(studentId,message);
//    		System.out.println("Student Has Not Been Registered  ");
//        }
      
        
        System.out.println("\n************************************\n");
	}
	
}
