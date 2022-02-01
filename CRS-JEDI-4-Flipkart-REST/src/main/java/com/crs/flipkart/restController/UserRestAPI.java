/**
 * 
 */
package com.crs.flipkart.restController;

/**
 * @author Abhinav
 *
 */

import javax.validation.Valid;
import javax.validation.ValidationException;
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

import com.crs.flipkart.bean.CourseCatalog;
import com.crs.flipkart.business.NotificationService;
import com.crs.flipkart.business.NotificationServiceInterface;
import com.crs.flipkart.business.StudentService;
import com.crs.flipkart.business.StudentServiceInterface;
import com.crs.flipkart.business.UserService;
import com.crs.flipkart.business.UserServiceInterface;
import com.crs.flipkart.exception.CourseNotAddedException;
import com.crs.flipkart.exception.CourseNotDeletedException;
import com.crs.flipkart.exception.StudentNotRegisteredException;
import com.crs.flipkart.exception.UserNotFoundException;


@Path("/user")
public class UserRestAPI {
	 	static UserServiceInterface userInterface = new UserService();
	 	static StudentServiceInterface studentInterface = new StudentService();

	/**
	 * 
	 * @param id: id of the user
	 * @param password: new password to be stored in db.
	 * @return 
	 * @return @return 201, if password is updated, else 500 in case of error
	 */
	 	@PUT
	 	@Path("/updatePassword")
	 	@Produces(MediaType.APPLICATION_JSON)
	 	public Response updatePassword(
	 			@NotNull
				@Email(message = "Invalid User ID: Not in email format")
				@QueryParam("id") String id,
				@NotNull
				@Size(min = 4 , max = 20 , message = "Password length should be between 4 and 20 characters")
				@QueryParam("password") String password) {
	    	
	        if(userInterface.updatePassword(id,password)) 
	        	return Response.status(201).entity("Password updated successfully! ").build();
	        else
	        	return Response.status(500).entity("Something went wrong, please try again!").build();
	    	}
	    
//	 	@POST
//		@Path("/studentRegistration")
//		@Consumes(MediaType.APPLICATION_JSON)
//	 	public static void registerStudent() {
//
//	    	try{
//	    	//input all the student details
//	        logger.info("Enter Id:");
//	        String id = sc.next();
//
//	        logger.info("Enter Name:");
//	        String name = sc.next();
//
//	        logger.info("Enter Password:");
//	        String password = sc.next();
//
//	        logger.info("Enter Branch:");
//	        String branch = sc.next();
//	        
//	        int role = 1;
//
//	        
//
//	        String newUserID = studentInterface.signup(id, password, branch, name, role);
//	        
//	        logger.info("Thankyou For Registration, Wait for the Admin Approval");
//	    	}
//	    	catch(StudentNotRegisteredException ex){
//				logger.error("Something went wrong! "+ex.getMessage() +" not registered. Please try again");
//			}
//	    }
//	 	
	 	
	 	/**
		 * 
		 * @param id
		 * @param password
		 * @return 
		 */
		
		@POST
		@Path("/login")
		@Consumes(MediaType.APPLICATION_JSON)
	    @Produces(MediaType.APPLICATION_JSON)
		public Response loginUser(
				@QueryParam("id") String id,
				@QueryParam("password") String password) throws CourseNotAddedException, CourseNotDeletedException {
   
	        try {
	        	 int loggedIn = -1;
		        loggedIn = userInterface.verifyUser(id, password);
	
		        if (loggedIn ==1 || loggedIn == 2 || loggedIn == 3) { 
		            switch (loggedIn) {
		                // Student
		                case 1: {
		                	boolean isApproved = userInterface.verifyApproval(id);
		                	if(isApproved) {
		                		return Response.status(200).entity("Login successful").build();
		                	}else {
		                		return Response.status(200).entity("Login unsuccessful! Student " + id + " has not been approved by the administration!").build();
		                	}
		                    
		                }
		                   
		                    
		                case 2:
		                	return Response.status(200).entity("Login successful").build();
		                    
		                    
		                case 3:
		                	return Response.status(200).entity("Login successful").build();
		                    
		            }
		        }else {
		        	return Response.status(500).entity("Invalid credentials!").build();
		        }
	        
	        }catch(UserNotFoundException ex) {
	        	 return Response.status(500).entity(ex.getMessage()).build();
	        }
	        return Response.status(500).entity("Login Not successful").build();
	    }
}
