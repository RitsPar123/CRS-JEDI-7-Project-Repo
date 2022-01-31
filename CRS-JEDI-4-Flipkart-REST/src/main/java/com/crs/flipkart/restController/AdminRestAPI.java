package com.crs.flipkart.restController;

import java.util.List;
import java.util.Scanner;
import java.util.Set;


import org.apache.log4j.Logger;

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
    private Response addCourse(@Valid Course course) throws CourseNotAddedException{
		
        try {
			adminInterface.addCourse(course);
			return Response.status(201).entity("Course with courseCode: " + course.getCourseId() + " added to catalog").build();
		} catch (CourseFoundException e) {
			// TODO Auto-generated catch block
			return Response.status(409).entity(e.getMessage()).build();
		}

    }

	/**
	 * /admin/deleteCourse
	 * REST-services for dropping a course from catalog
	 * @param courseCode
	 * @return 
	 * @return
	 */
	@PUT
	@Path("/deleteCourse")
	@Produces(MediaType.APPLICATION_JSON)
    public Response deleteCourse(
		@Size(min = 4 , max = 10 , message = "Course Code length should be between 4 and 10 character")
		@NotNull
		@QueryParam("courseCode") String courseCode) throws ValidationException{
        boolean deleted = false;
        try {
			adminInterface.deleteCourse(courseCode);
			return Response.status(201).entity("Course with courseCode: " + courseCode + " deleted from catalog").build();
		} catch (CourseNotFoundException | CourseNotDeletedException e) {
			// TODO Auto-generated catch block
			return Response.status(409).entity(e.getMessage()).build();
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
				boolean addUser = adminInterface.addUser(professor.getId(),professor.getPassword(),professor.getUserName());
				
				return Response.status(201).entity("Professor with professorId: " + professor.getId() + " added").build();
			} catch (UserNotAddedException e) {
				// TODO Auto-generated catch block
				logger.error(e.getMessage());
				return Response.status(409).entity(e.getMessage()).build();
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

    @GET
	@Path("/viewCourses")
	@Produces(MediaType.APPLICATION_JSON)
    public List<Course> viewCourses() {
        // TODO Auto-generated method stub
//    	List<Course> cou = new ArrayList<Course>();
       return  adminInterface.viewCourse();
        
    }
    
    
	@PUT
	@Path("/approveStudentReg")
	@Produces(MediaType.APPLICATION_JSON)
	public Response activateGradeCard(@Min(value = 1, message = "Student ID should not be less than 1")
	@Max(value = 9999, message = "Student ID should be less than 10000")
	@NotNull
	@QueryParam("studentId") String studentId) {
		// TODO Auto-generated method stub
            
                	adminInterface.approveStudentRegistration(studentId);
                	return Response.status(201).entity("Student with studentId: " + studentId + " approved").build();

                }

	}
	
	/**
	 * /admin/approveStudent
	 * REST-service for approving the student admission
	 * @param studentId
	 * @return
	 */
//	@PUT
//	@Path("/approveStudentCourse")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response studentCourseAllot(
//			@Min(value = 1, message = "Student ID should not be less than 1")
//			@Max(value = 9999, message = "Student ID should be less than 10000")
//			@NotNull
//			@QueryParam("studentId") String studentId) {
//		// TODO Auto-generated method stub
//    
//
////	       	try {
//	       	adminInterface.updateRegistered(studentId);
//	        String  	message = "Success";
//	       	notificationService.sendNotification(studentId,message);
//	       	return Response.status(201).entity("Student with studentId: " + studentId + " approved").build();
//	       	
////	       	}catch{
////	       		
////	       	}
//
//	}
	

