/**
 * 
 */
package com.crs.flipkart.restController;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.business.ProfessorService;
import com.crs.flipkart.business.ProfessorServiceInterface;
import com.crs.flipkart.dao.AdminDaoOperation;
import com.crs.flipkart.exception.NoCourseFoundException;


/**
 * @author hardik.kothari
 *
 */



@Path("/professor")
public class ProfessorRestAPI {
	
	ProfessorServiceInterface professorService=new ProfessorService();
    public static Logger logger = Logger.getLogger(ProfessorRestAPI.class);

	/**
     * /professor/selectCourse
     * REST-service for selecting a course for professor
     * 
     * @param profId
     * @param courseId
     * @param courseName
     * @return
     */
		@POST
		@Path("/selectCourse")
		@Produces(MediaType.APPLICATION_JSON)
		public Response selectCourse(@NotNull @QueryParam("profId") String profId , @NotNull @QueryParam("courseId") String courseId,  @QueryParam("courseName") String courseName ) 
		 {
				
			 if(professorService.selectCourse(profId ,courseId,courseName))
				{
					return Response.status(201).entity("Professor alloted couseId " + courseId ).build();
				}
			else
				{
					return Response.status(201).entity(" Unable to alloted couseId " + courseId ).build();
				}
			
							
		 }

		/**
	     * /professor/viewRegisteredCourses
	     * REST-service for viewing Registered Courses for a professor
	     * 
	     * @param profId
	     * @return
	     */ 
	 
	 	@GET
		@Path("/viewRegisteredCourses")
	 	@Produces(MediaType.APPLICATION_JSON)
		public List<Course> viewRegisteredCourses(@NotNull @QueryParam("profId") String profId ) 
		 {
				
						
			 try {
					return professorService.viewRegisteredCourses(profId);
					} 
					catch(NoCourseFoundException ex) {
						logger.info("Exception: "+ ex.getMessagewithid());
						return null;
					}
			 
		 }
		 
	 	/**
	     * /professor/addGrades
	     * REST-service for adding grade for a specific Student by a professor
	     * 
	     * @param profId
	     * @param courseId
	     * @param studentId
	     * @param grade
	     * @return
	     */ 
	 	
		 	@POST
			@Path("/addGrades")
		 	@Produces(MediaType.APPLICATION_JSON)
			public Response addGrades(@NotNull @QueryParam("profId") String profId , @NotNull @QueryParam("courseId") String courseId,
					@NotNull @QueryParam("studentId") String studentId , @NotNull @QueryParam("grade") int grade) 
			 {
					
							
				if( professorService.addGrades(profId,courseId,studentId,grade))
				{
					return Response.status(201).entity("Grade "+ grade +" added Succesfully to studentID "
				+ studentId +"in CourseId  "+ courseId ).build();
				}else
				{
					return Response.status(201).entity("Unable to add grades").build();
				}
				 
			 }
		 
		 	
		 	/**
		     * /professor/showCourses
		     * REST-service for viewing  Courses a professor can  register for.
		     * @return
		     */ 
		 	
			 
			@GET
			@Path("/showCourses")
			@Produces(MediaType.APPLICATION_JSON)
			public List<Course> showCourses() 

			{
						
								
					try {
						 return professorService.showCourses();
						 }
						 catch(NoCourseFoundException ex) {
							 logger.error("Exception: "+ex.getMessage());
							 return null;
						 }		
					 
					 
			}
				
			
			/**
		     * /professor/viewRegisteredStudents
		     * REST-service for viewing Registered Students in a specific Course taught by a professor
		     * 
		     * @param profId
		     * @param courseId
		     * @return
		     */ 
			
				 
			@GET
			@Path("/viewRegisteredStudents")
			@Produces(MediaType.APPLICATION_JSON)
			public List<Student> viewRegisteredStudents(@NotNull @QueryParam("profId") String profId , @NotNull @QueryParam("courseId") String courseId)
				{
					return professorService.viewRegisteredStudents(profId,courseId);						 
				}
	 
	 
	 
			
	}	