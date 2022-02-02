
package com.crs.flipkart.restController;


import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.crs.flipkart.bean.RegisteredCourses;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.business.AdminService;
import com.crs.flipkart.business.AdminServiceInterface;
import com.crs.flipkart.business.NotificationService;
import com.crs.flipkart.business.NotificationServiceInterface;
import com.crs.flipkart.business.PaymentService;
import com.crs.flipkart.business.PaymentServiceInterface;

/**
 * @author nandini mehta
 *
 */
public class StudentRestAPI{
	NotificationServiceInterface notificationService = new NotificationService();
	PaymentServiceInterface paymentInterface = new PaymentService();
	AdminServiceInterface adminInterface = new AdminService();
	/*
	 * method to view grade card
	 */
	@GET
	@Path("/viewGradeCard")
	@Produces(MediaType.APPLICATION_JSON)
	private void viewGradeCard(String studentId) {
		// TODO Auto-generated method stub
        
    	
            Student stud = new Student();
            stud = adminInterface.viewStudentData(studentId);
            
            System.out.println("Details are  ->");
            System.out.println("Id -> " + stud.getId() + " Name -> " + stud.getUserName() + " Branch -> " + stud.getBranch());

                List<RegisteredCourses> registeredCourses = adminInterface.activateGradeCard(studentId);
     
                if(stud.isReportApproved()) {
                for(RegisteredCourses course:registeredCourses) {
                	System.out.println("CourseId -> " + course.getCourseId() + " Grade ->  " + course.getGrade());
         
                }
                }
            	System.out.println("Student Report Card");
       
	}
	


}
