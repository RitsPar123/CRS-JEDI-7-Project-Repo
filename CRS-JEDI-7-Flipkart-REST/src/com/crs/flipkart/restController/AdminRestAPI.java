/**
 * 
 */
package com.crs.flipkart.application;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.ValidationException;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.validator.constraints.Email;

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



@Path("/admin")
public class AdminRestAPI {

	
    AdminServiceInterface adminInterface = new AdminService();
    static NotificationServiceInterface notificationService = new NotificationService();
    Scanner sc = new Scanner(System.in);
    private static Logger logger = Logger.getLogger(AdminDaoOperation.class);

   

	/**
	 * /admin/addCourse
	 * REST-service for adding a new course in catalog
	 * @param course
	 * @return
	 */
	@POST
	@Path("/addCourse")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    private void addCourse() throws CourseNotAddedException{
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
    
	/**
	 * /admin/addProfessor
	 * REST-service for addding a new professor
	 * @param professor
	 * @return
	 */

    @POST
	@Path("/addProfessor")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
    public Response addProfessor(@Valid Professor professor){

		try {
			adminInterface.addProfessor(professor);
			try {
				boolean addUser = adminInterface.addUser(id,password,name);
				
				return Response.status(201).entity("Professor with professorId: " + professor.getId() + " added").build();
			} catch (UserNotAddedException e) {
				// TODO Auto-generated catch block
				logger.error(e.getMessage());
			}
		} catch (UserIdAlreadyInUseException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
			return Response.status(409).entity(e.getMessage()).build();
		} catch (ProfessorNotAddedException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
			return Response.status(409).entity(e.getMessage()).build();
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

    
    @GET
	@Path("/viewPendingAdmissions")
	@Produces(MediaType.APPLICATION_JSON)
    public List<Student> viewPendingApproval() {

        return adminInterface.viewPendingApproval();
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
