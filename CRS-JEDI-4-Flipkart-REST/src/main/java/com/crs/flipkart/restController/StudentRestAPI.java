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
import com.crs.flipkart.bean.Payment;
import com.crs.flipkart.bean.RegisteredCourses;
import com.crs.flipkart.bean.SemesterRegistration;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.business.AdminService;
import com.crs.flipkart.business.NotificationService;
import com.crs.flipkart.business.NotificationServiceInterface;
import com.crs.flipkart.business.PaymentService;
import com.crs.flipkart.business.PaymentServiceInterface;
import com.crs.flipkart.business.RegisteredCoursesService;
import com.crs.flipkart.business.RegisteredCoursesServiceInterface;
import com.crs.flipkart.business.SemesterRegistrationService;
import com.crs.flipkart.business.SemesterRegistrationServiceInterface;
import com.crs.flipkart.business.StudentService;
import com.crs.flipkart.business.StudentServiceInterface;
import com.crs.flipkart.dao.AdminDaoInterface;
import com.crs.flipkart.dao.AdminDaoOperation;
import com.crs.flipkart.dao.NotificationDaoInterface;
import com.crs.flipkart.dao.NotificationDaoOperation;
import com.crs.flipkart.dao.PaymentDaoInterface;
import com.crs.flipkart.dao.PaymentDaoOperations;
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

	NotificationServiceInterface notificationInterface = new NotificationService();
	PaymentServiceInterface paymentInterface = new PaymentService();
	AdminServiceInterface adminInterface = new AdminService();
	SemesterRegistrationServiceInterface semesterRegistrationInterface = new SemesterRegistrationService();
	StudentDaoInterface studentDaoInterface = new StudentDaoOperation();
	RegisteredCoursesDaoInterface registeredCoursesDaoInterface = new RegisteredCoursesDaoOperation();
	RegisteredCoursesServiceInterface registeredCoursesInterface = new RegisteredCoursesService();
	NotificationDaoInterface notificationDaoInterface = new NotificationDaoOperation();
	AdminDaoInterface adminDaoInterface = new AdminDaoOperation();
	PaymentDaoInterface paymentDaoInterface = new PaymentDaoOperations();
	StudentServiceInterface studentInterface = new StudentService();

	@GET
	@Path("/showCourse")
	@Produces(MediaType.APPLICATION_JSON)
	public Response showCourse() {

		/**
		 * Method to showCourse
		 * 
		 * @return
		 */

		List<Course> availableCourses = semesterRegistrationInterface.showCourse();

		if (availableCourses.size() > 0) {
			return Response.status(200).entity(availableCourses).build();
		}
		return Response.status(200).entity("There are no courses available").build();
	}

	@POST
	@Path("/addCourse")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addCourse(@QueryParam("studentId") String studentId, @QueryParam("courseId") String courseId)
			throws CourseNotFoundException {
		try {
			boolean a = semesterRegistrationInterface.addCourse(studentId, courseId);

			if (a == false) {
				return Response.status(200).entity("Course has already been added").build();

			}
			return Response.status(200).entity("Course has been added successfully").build();
		} catch (CourseNotFoundException ex) {
			return Response.status(400).entity("Course not found").build();
		}

	}
	
	/**
	 * Rest service for drop course 
	 * @param studentId
	 * @param courseId
	 * @return
	 */
	 
	@DELETE
	@Path("/dropCourse")
	@Produces(MediaType.APPLICATION_JSON)
	public Response dropCourse(@QueryParam("studentId") String studentId, @QueryParam("courseId") String courseId) {

		if (!registeredCoursesDaoInterface.hasCourse(courseId, studentId)) {
			return Response.status(200).entity("You do not have this course added!").build();
		}

		try {
			semesterRegistrationInterface.dropCourse(courseId, studentId);
		} catch (Exception ex) {
			return Response.status(400).entity("Course not deleted due to internal error").build();
		}

		return Response.status(200).entity("Course has been dropped successfully ").build();
	}

	/**
	 * 
	 * Rest service for showing selected courses of student with given student id
	 * @param studentId
	 * @return
	 */
	@GET
	@Path("/showSelectedCourses")
	@Produces(MediaType.APPLICATION_JSON)

	public Response showSelectedCourses(@QueryParam("studentId") String studentId) {

		List<Course> selectedCourses = registeredCoursesInterface.getSelectedCourses(studentId);

		if (selectedCourses.size() > 0) {
			return Response.status(200).entity(selectedCourses).build();
		}
		return Response.status(200).entity("There are no courses selected for display").build();
	}

	
	/**
	 * Rest service for payment process
	 * @param paymentobj
	 * @return
	 */
	@POST
	@Path("/payment")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response payment(@QueryParam("studentid") String studentid, @QueryParam("mode") String mode) {

		int isRegister = registeredCoursesInterface.getStatus(studentid);

		if (isRegister == 0) {

			return Response.status(200).entity("Your Course Allocation Registration is still pending").build();
		}

		if (mode.equals("online") || mode.equals("Online")) {
			try {

				boolean isPaid = paymentInterface.onlinePayment(studentid);
				if (isPaid) {
					return Response.status(200).entity("Fees has been successfully paid through online mode").build();
				}
				return Response.status(200).entity("Fees cannot be paid").build();
			} catch (Exception ex) {
				return Response.status(400).entity("Fees not paid due to some internal error").build();
			}

		} else if (mode.equals("offline") || mode.equals("Offline")) {
			try {

				boolean isPaid = paymentInterface.offlinePayment(studentid);
				if (isPaid) {
					return Response.status(200).entity("Fees has been successfully paid through offline mode").build();
				}
				return Response.status(200).entity("Fees cannot be paid").build();
			} catch (Exception ex) {
				return Response.status(400).entity("Fees not paid due to some internal error").build();
			}

		}
		return Response.status(200).entity("This mode of payment is not supported").build();
	}
	
	/**
	 * Rest service to show notification
	 * @param id
	 * @return
	 */
	@GET
	@Path("/showNotification")
	@Produces(MediaType.APPLICATION_JSON)
	public Response showNotifications(@QueryParam("id") String id) {
		List<Notification> notification = notificationInterface.showNotifications(id);
		if (notification != null && notification.size() > 0) {
			return Response.status(200).entity(notification).build();
		}

		return Response.status(200).entity("No Notifications are Present").build();
	}
	
	/**
	 * Rest service for viewing registered courses
	 * @param id
	 * @return
	 */
	@GET
	@Path("/viewRegisteredCourses")
	@Produces(MediaType.APPLICATION_JSON)
	public Response viewRegisteredCourses(@QueryParam("id") String id) {

		List<Course> courses = studentInterface.viewRegisteredCourses(id);
		if (courses == null) {

			return Response.status(200).entity("approval still pending").build();
		}
		return Response.status(200).entity(courses).build();
	}
	
	
	/**
	 * Rest service to view report card with given student ID
	 * @param studentId
	 * @return
	 */
	@GET
	@Path("/viewReportCard")
	@Produces(MediaType.APPLICATION_JSON)
	public Response viewReportCard(@QueryParam("studentId") String studentId) {
		List<RegisteredCourses> registeredCourses = studentInterface.viewReportCard(studentId);

		if (registeredCourses == null) {
			return Response.status(200).entity("Report card still not generated").build();
		}

		return Response.status(200).entity(registeredCourses).build();

	}

}
