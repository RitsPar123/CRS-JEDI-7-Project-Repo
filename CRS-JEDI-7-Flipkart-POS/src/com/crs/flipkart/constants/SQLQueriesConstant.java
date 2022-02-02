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
	public static final String ADD_COURSE = "insert into course (CourseId,CourseName) values(?,?)";
	public static final String DELETE_COURSE = "delete from course where CourseId = ?";
	public static final String ADD_PROFESSOR = "insert into professor(PId,Department) values(?,?)";
	public static final String GET_REGISTRATION_STATUS = "select isRegistered from student where SId = ?";
	public static final String GET_STUDENT_ACOURSES_BY_ID = "select * from registeredcourse where (SId = ? AND isRegistered = 1)";
	public static final String GET_STUDENT_SCOURSES_BY_ID = "select * from registeredcourse where (SId = ? AND isRegistered = 0)";
	public static final String ADD_COURSE_FOR_STUDENT = "insert into registeredcourse (CourseId,SId,IsRegistered,Grade) values (?,?,0,?)";
	public static final String HAS_COURSE_ADDED = "select * from registeredcourse where (courseid = ? AND sid = ?)";
	public static final String DROP_COURSE_FOR_STUDENT = "delete from registeredcourse where (courseid = ? AND sid = ?)";
	public static final String APPROVE_STUDENT = "update student set IsApproved = 1 where SId = ?";
	public static final String VERIFY_APPROVAL = "select IsApproved from student inner join user on Id=SId where Id = ?";
	public static final String PENDING_STUDENT = "select student.SId,student.Branch,user.Name from user inner join student on student.SID = user.Id where student.IsApproved=0";
	public static final String VIEW_COURSES = "select * from course";
	public static final String VIEW_SELECT_COURSE = "select CourseId from registeredcourse where SId = ? AND IsRegistered=0";
	public static final String GET_COURSE_SEAT = "select SeatCount from course where CourseId = ?";
	public static final String APPROVE_STUDENT_REGISTRATION = "update registeredcourse set IsRegistered = 1 where  SId=?";
	public static final String ADD_PAYMENT = "insert into Payment (SId,PaymentId,PaymentMethod,Amount,TransactionDate,FeeStatus) values (?,?,?,?,?,1)";
	public static final String SET_NOTIFICATION = "insert into notification (NotificationId,SId,Message) values (?,?,?)";
	public static final String STUDENT_DATA = "select student.SId,student.Branch,user.Name,student.IsRegistered,student.IsReportApproved from user inner join student on student.SID = user.Id  where SId = ?";
	public static final String REGISTERED_COURSE = "select * from registeredcourse where (SId = ? AND IsRegistered = 1)";
	public static final String APPROVE_REPORT = "update student set IsReportApproved = 1 where SId = ?";
	public static final String GET_ALL_COURSES = "select * from course ";
	public static final String CHECK_COURSE_EXISTENCE = "select * from course where courseid = ?";
	public static final String CHECK_PAYMENT_STATUS = "select isregistered from student where sid = ?";
	
	public static final String  ASSIGN_COURSE_TO_PROF ="update course set PID = ? where courseID = ? and courseName = ? and PID is null";
	public static final String  VIEW_PROF_COURSES = "select CourseId, CourseName from course where PId = ? ";
	public static final String  ADD_GRADES = "UPDATE registeredcourse SET grade = ? where sId = ? and courseId = ? LIMIT 1";
	
	public static final String  CHECK_STUDENT_REGISTRATION_FOR_COURSE = "select * from registeredcourse where sid = ? and courseid = ? and IsRegistered = 1";
	public static final String  CHECK_GRADE_UPDATE_TYPE = "select * from registeredcourse where sid = ? and courseid = ? and grade is not null";
	public static final String  CHECK_PROF_COURSE = "select * from course where pid = ? and courseid = ? ";
	public static final String  COURSE_SELECTION_LIST ="Select CourseId,courseName,seatCount from course where pid is null";
	public static final String  VIEW_REGISTERED_STUDENTS ="Select user.id ,user.name from (user INNER JOIN registeredcourse ON registeredcourse.sid = user.id ) where courseid = ? and IsRegistered = 1";
	public static final String  DELETE_ENTRY = "delete from registeredcourse where SId= ?";
	public static final String  UPDATE_COURSE_ENTRY = "update course set SeatCount = SeatCount+1 where CourseId = ?";
	public static final String	GET_STATUS = "select IsRegistered from registeredcourse where SId = ?";
	public static final String 	UPDATE_STUDENT_STATUS = "update student set IsRegistered = 1 where SId = ?";
	public static final String	NOTIFICATION_STUDENT = "select Message from notification where SId=?";
	public static final String  ADD_USER_PRO = "insert into user(Id,Name,Password,Role) values(?,?,?,2)";
}
