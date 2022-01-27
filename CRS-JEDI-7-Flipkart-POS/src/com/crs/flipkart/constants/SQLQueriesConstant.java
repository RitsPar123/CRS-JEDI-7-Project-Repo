/**
 * 
 */
package com.crs.flipkart.constants;

/**
 * @author Abhinav
 *
 */
public class SQLQueriesConstant {

	public static final String ADD_USER = "insert into User (Id,Name,Password,Role) values (?,?,?,?)";
	public static final String ADD_STUDENT = "insert into Student (SId,Branch,IsApproved,IsRegistered,IsReportApproved) values (?,?,0,0,0)";
	public static final String VERIFY_USER = "select Password, Role from user where Id = ?";
	public static final String UPDATE_PASSWORD = "update user set Password = ? where Id = ?";
	public static final String ADD_COURSE = "insert into course (CourseId,PId,CourseName) values(?,?,?)";
	public static final String DELETE_COURSE = "delete from course where CourseId = ?";
	public static final String ADD_PROFESSOR = "insert into professor(PId,Department) values(?,?)";
	public static final String APPROVE_STUDENT = "update student set IsApproved = 1 where SId = ?";
	public static final String VERIFY_APPROVAL = "select IsApproved from student inner join user on Id=SId where Id = ?";
	public static final String PENDING_STUDENT = "select student.SId,student.Branch,user.Name from user inner join student on student.SID = user.Id where student.IsApproved=0";
	public static final String VIEW_COURSES = "select * from course";
	public static final String VIEW_SELECT_COURSE = "select CourseId from registeredcourse where SId = ? AND IsRegistered=1";
	public static final String GET_COURSE_SEAT = "select SeatCount from course where CourseId = ?";
	public static final String APPROVE_STUDENT_REGISTRATION = "update student set IsRegistered = 2 where SId = ?";
	public static final String ADD_PAYMENT = "insert into Payment (SId,PaymentId,PaymentMethod,Amount,TransactionDate,FeeStatus) values (?,?,?,?,?,1)";
	public static final String SET_NOTIFICATION = "insert into Notification (NotificationId,SId,Message) values (1,?,?)";
	public static final String STUDENT_DATA = "select student.SId,student.Branch,user.Name,student.IsRegistered from user inner join student on student.SID = user.Id  where SId = ?";
}
