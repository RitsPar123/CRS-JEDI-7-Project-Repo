/**
 * 
 */
package com.crs.flipkart.restController;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.crs.flipkart.business.AdminServiceInterface;
import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Notification;
import com.crs.flipkart.bean.RegisteredCourses;
import com.crs.flipkart.bean.SemesterRegistration;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.business.AdminService;
import com.crs.flipkart.business.NotificationService;
import com.crs.flipkart.business.NotificationServiceInterface;
import com.crs.flipkart.business.PaymentService;
import com.crs.flipkart.business.PaymentServiceInterface;
import com.crs.flipkart.dao.AdminDaoInterface;
import com.crs.flipkart.dao.AdminDaoOperation;
import com.crs.flipkart.dao.NotificationDaoInterface;
import com.crs.flipkart.dao.NotificationDaoOperation;
import com.crs.flipkart.dao.RegisteredCoursesDaoInterface;
import com.crs.flipkart.dao.RegisteredCoursesDaoOperation;
import com.crs.flipkart.dao.StudentDaoInterface;
import com.crs.flipkart.dao.StudentDaoOperation;
import com.crs.flipkart.exception.CourseNotFoundException;
import com.crs.flipkart.dao.NotificationDaoOperation;
import com.crs.flipkart.dao.NotificationDaoInterface;

/**
 * @author nandini mehta
 *
 */
@Path("/student")
public class StudentRestAPI {

	NotificationServiceInterface notificationService = new NotificationService();
	PaymentServiceInterface paymentInterface = new PaymentService();
	AdminServiceInterface adminInterface = new AdminService();
	StudentDaoInterface studentDaoInterface = new StudentDaoOperation();
	RegisteredCoursesDaoInterface registeredCoursesDaoInterface = new RegisteredCoursesDaoOperation();
	NotificationDaoInterface notificationDaoInterface = new NotificationDaoOperation();
	AdminDaoInterface adminDaoInterface = new AdminDaoOperation();

	@GET
	@Path("/viewReportCard")
	@Produces(MediaType.APPLICATION_JSON)
	public Response viewReportCard(@QueryParam("studentId") String studentId) {
		Student stud = new Student();
		stud = adminInterface.viewStudentData(studentId);

		if (!stud.isReportApproved()) {
			return Response.status(200).entity("The report card has not been generated").build();
		}
		List<RegisteredCourses> registeredCourses = adminInterface.activateGradeCard(studentId);

		return Response.status(200).entity(registeredCourses).build();

	}

	@GET
	@Path("/viewRegisteredCourses")
	@Produces(MediaType.APPLICATION_JSON)
	public Response viewRegisteredCourses(@QueryParam("id") String id) {
		int isRegistered = studentDaoInterface.getRegistrationStatus(id);

		if (isRegistered == 0) {
			return Response.status(200).entity("Registration in progress or incomplete!").build();
		}
		List<Course> courses = registeredCoursesDaoInterface.getApprovedCoursesById(id);
		return Response.status(200).entity(courses).build();
	}

	@GET
	@Path("/showNotification")
	@Produces(MediaType.APPLICATION_JSON)
	public Response showNotifications(@QueryParam("id") String id) {
		List<Notification> notification = notificationDaoInterface.getNoti(id);
		if (notification != null && notification.size() > 0) {
			return Response.status(200).entity(notification).build();
		}

		return Response.status(200).entity("No Notifications are Present").build();
	}

	@POST
	@Path("/signup")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response signup(@Valid Student student) {
		String studentId = null;
		 boolean resp = studentDaoInterface.signup(student);
		 if(resp)
		{return Response.status(200).entity("student has been added successfully").build();}
         
		 return Response.status(400).entity("There has not been added or there is some internal error").build();
	}

	@POST
	@Path("/addCourse")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addCourse(@Valid SemesterRegistration semesterRegistration,
			@QueryParam("courseId") String courseId) {
		try {
			registeredCoursesDaoInterface.isCourseAvailable(courseId);
		} catch (CourseNotFoundException ex) {
			return Response.status(400).entity("Course not found").build();
		}

		if (registeredCoursesDaoInterface.hasCourse(courseId, semesterRegistration.getStudentId())) {

			return Response.status(200).entity("You have this course added already!").build();
		}

		registeredCoursesDaoInterface.addCourse(courseId, semesterRegistration.getStudentId());
		return Response.status(200).entity("Course has been added successfully ").build();

	}

	@DELETE
	@Path("/dropCourse")
	@Produces(MediaType.APPLICATION_JSON)
	public Response dropCourse(@QueryParam("studentId") String studentId,
			@QueryParam("courseId") String courseId) {
		if (!registeredCoursesDaoInterface.hasCourse(courseId, studentId)) {
			return Response.status(200).entity("You do not have this course added!").build();
		}

		registeredCoursesDaoInterface.dropCourse(courseId, studentId);

		return Response.status(200).entity("Course has been dropped successfully ").build();
	}

	@GET
	@Path("/showCourse")
	@Produces(MediaType.APPLICATION_JSON)
	public Response showCourse() {
		List<Course> availableCourses = adminDaoInterface.getAllCourse();

		if (availableCourses.size() > 0) {
			return Response.status(200).entity(availableCourses).build();
		}
		return Response.status(200).entity("There are no courses available").build();
	}

	@GET
	@Path("/showSelectedCourses")
	@Produces(MediaType.APPLICATION_JSON)
	public Response showSelectedCourses(@QueryParam("studentId") String studentId) {
		System.out.println(studentId);
		List<Course> selectedCourses = registeredCoursesDaoInterface
				.getSelectedCourses(studentId);

		if (selectedCourses.size() > 0) {
			return Response.status(200).entity(selectedCourses).build();
		}
		return Response.status(200).entity("There are no courses selected for display").build();
	}

}
