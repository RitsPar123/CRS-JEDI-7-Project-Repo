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
}
