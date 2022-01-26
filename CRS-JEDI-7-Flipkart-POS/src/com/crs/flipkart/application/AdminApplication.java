/**
 * 
 */
package com.crs.flipkart.application;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.bean.Professor;
import com.crs.flipkart.business.AdminService;
import com.crs.flipkart.business.AdminServiceInterface;
import com.crs.flipkart.business.NotificationService;
import com.crs.flipkart.business.NotificationServiceInterface;

/**
 * @author harsh
 *
 */
public class AdminApplication {

    AdminServiceInterface adminInterface = new AdminService();
    static NotificationServiceInterface notificationService = new NotificationService();
    Scanner sc = new Scanner(System.in);

    public void showMenu() {

        System.out.println("----------------Admin Menu----------------\n");

        CreateMenu();

        int userInput = sc.nextInt();

        while (userInput != 8) {
        	
        	System.out.println("\nEnter Your Choice");
        	
            switch (userInput) {
                case 1:
                    addCourse();
                    break;
                case 2:
                    // delete Course
                    deleteCourse();
                    break;
                case 3:
                    // add Professor
                    addProfessor();
                    break;
                case 4:
                    // view Pending Approvals
                    viewPendingApproval();
                    break;
                case 5:
                    // Approve Registration
                    approveRegistration();
                    break;

                case 6:
                    // View Courses
                    viewCourses();
                    break;
                    
                case 10:
                    // Allot Course
                    studentCourseAllot();
                    break;
                default:
                    System.out.println("Invalid Input");
            }
            CreateMenu();
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
        System.out.println("7  View Student Data");
        System.out.println("8  Activate Grade Card");
        System.out.println("9  Approve Student Semester Registration");
        System.out.println("10  Student Course Allocation");

    }

    private void addCourse() {
        System.out.println("Enter Course Code");
        String courseId = sc.next();

        System.out.println("Enter Course Name");
        String courseName = sc.next();

        Course course = new Course(10, courseName, courseId, "aaaa");

        boolean added = false;
        added = adminInterface.addCourse(course);
        
        if(added)
        	System.out.println("\n The Course Has Been Added\n");
    }

    public void deleteCourse() {
        System.out.println("Enter Course Code");
        String courseId = sc.next();

        boolean deleted = false;
        deleted = adminInterface.deleteCourse(courseId);

        if (deleted)
            System.out.println("Course is Deleted");
    }

    private void addProfessor() {
        System.out.println("Enter details of the Professor to be added: ");

        System.out.println("Enter ProfessorId ");
        String id = sc.next();

        System.out.println("Enter Department ");
        String department = sc.next();

        Professor professor = new Professor();

        professor.setDepartment(department);
        professor.setId(id);

        boolean isProfessorAdded = adminInterface.addProfessor(professor);

        if (isProfessorAdded) {
            System.out.println("Professor created successfully.\n");
        }
    }

    private void approveRegistration() {
        // TODO Auto-generated method stub
        System.out.print("Enter Student's ID");
        String studentUserId = sc.next();

        boolean isApprove = adminInterface.approveStudent(studentUserId);

        if (isApprove)
            System.out.println("Student Registration is being Approved\n");
    }

    private void viewPendingApproval() {

        List<Student> studentList = adminInterface.viewPendingApproval();
        System.out.println("Student Details\n");
        for (Student s : studentList) {
            System.out.println("Id -> " + s.getId() + " Name -> " + s.getUserName() + " Branch ->  " + s.getBranch());
        }
        System.out.println("************************************");
    }

    private void viewCourses() {
        // TODO Auto-generated method stub
        List<Course> courseList = adminInterface.viewCourse();
        System.out.println("Course Details\n");
        for (Course c : courseList) {
            System.out.println(
                    " Id -> " + c.getCourseId() + " Name -> " + c.getCourseName() + "  Seat Left -> " + c.getCount());
        }
        System.out.println("************************************");
    }
    
    private void studentCourseAllot() {
		// TODO Auto-generated method stub
    	
    	System.out.print("Enter Student's ID");
        String studentId = sc.next();
        Set<String> courseList = adminInterface.viewSelectedCourse(studentId);  
        
        String message;
        boolean status = true;
    
        for (String c : courseList) {
        	int seatLeft = adminInterface.getCouseList(c);
        	System.out.println(seatLeft);
        	if(seatLeft >= 7) {
        		status = false;
        		message = "Less than Three Students have Registered for this Course\n";
        		break;
        	}
        }
        
        if(status == true) {
        	System.out.println("Student Has Been Registered");
        	adminInterface.updateRegistered(studentId);
        	message = "You Have Been Registered";
        	notificationService.sendNotification(studentId,message);
        }
        System.out.println("************************************\n");
	}
}
