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
	public static final String DELETE_COURSE = "delete from course where id = ?";
	public static final String ADD_PROFESSOR = "insert into professor(PId,Department) values(?,?)";
	public static final String GET_REGISTRATION_STATUS = "select isRegistered from student where SId = ?";
	public static final String GET_STUDENT_RCOURSES_BY_ID = "select * from registeredcourse where (SId = ? AND isRegistered = 1)";
	public static final String GET_STUDENT_SCOURSES_BY_ID = "";
	public static final String ADD_COURSE_FOR_STUDENT = "insert into registeredcourse (courseId,sId,isRegistered,Grade) values (?,?,0,0)";
	public static final String HAS_COURSE_ADDED = "select * from registeredcourse where (courseid = ? AND sid = ?)";
	public static final String DROP_COURSE_FOR_STUDENT = "delete from registeredcourse where (courseid = ? AND sid = ?)";
}
