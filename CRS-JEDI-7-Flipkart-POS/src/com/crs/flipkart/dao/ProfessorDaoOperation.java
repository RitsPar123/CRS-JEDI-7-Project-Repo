/**
 * 
 */
package com.crs.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.constants.SQLQueriesConstant;
import com.crs.flipkart.exception.CourseAlreadyAssignedException;
import com.crs.flipkart.exception.CourseNotFoundException;
import com.crs.flipkart.exception.GradeNotAddedException;
import com.crs.flipkart.exception.NoCourseFoundException;
import com.crs.flipkart.exception.StudentNotFoundException;
import com.crs.flipkart.utils.CRSDb;

/**
 * @author Abhinav
 *
 */
public class ProfessorDaoOperation implements ProfessorDaoInterface {
	
	Connection conn = CRSDb.getConnect();
	PreparedStatement stmt = null;
	private static Logger logger = Logger.getLogger(ProfessorDaoOperation.class);


	/**
    * {@inheritDoc}
    */  
	@Override
	public boolean selectCourse(String profId,String courseid, String coursename) {
		// TODO Auto-generated method stub
		try {
			
			String query = SQLQueriesConstant.ASSIGN_COURSE_TO_PROF;
			stmt = conn.prepareStatement(query);
			stmt.setString(1, profId);
			stmt.setString(2, courseid);
			stmt.setString(3, coursename);
		//	stmt.setString(4, "aaaa");
			
			int result = stmt.executeUpdate();
			
			if(result==0) 
			{
				throw new CourseAlreadyAssignedException(courseid);
				}
			else 
			{
				logger.info("Course has been added Successfully");
				return true;
			}
			
		}catch (CourseAlreadyAssignedException u) {
			// TODO Auto-generated catch block
			logger.error("Exception : " + u.getMessage());
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error("Exception" + e.getMessage());
		}
		return false;
	}
	
	/**
    * {@inheritDoc}
    */ 
	@Override
	public List<Course> viewRegisteredCourses(String id) {
		// TODO Auto-generated method stub
		
		List<Course> RegisteredCourses = new ArrayList<Course>();
		
		try {
			
				String sql=SQLQueriesConstant.VIEW_PROF_COURSES;
				
				stmt = conn.prepareStatement(sql);
			    stmt.setString(1, id);
			    ResultSet rc = stmt.executeQuery();
			    
				while(rc.next()) {
					
					String cid  = rc.getString("CourseId");
			        	String cname = rc.getString("CourseName");
			         
			        	Course c= new Course();
			        	c.setCourseId(cid);
			        	c.setCourseName(cname);
			        
			        	RegisteredCourses.add(c);
			        
				}
				
				stmt.close();
			  //  conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error("Exception" + e.getMessage());
			
		}
		return RegisteredCourses;
}

	/**
    * {@inheritDoc}
    */ 
	@Override
	public boolean addGrades(String professorId, String courseId, String studentId, int grade) {
		String query;
		if(checkGradeValidity(professorId,studentId,courseId)) {
			
			if(CheckGradeUpdateType(studentId , courseId)) {
				
				System.out.println("Record already exists\n");
				System.out.print("Press N if you donot want to overwrite :  ");
				Scanner sc = new Scanner(System.in);
				String choice = sc.next();
				System.out.println();
				
				if(choice.equalsIgnoreCase("N")) {
					logger.info("Mark updation cancelled");
					return true;	
				}
				
			}
			try {
				query = SQLQueriesConstant.ADD_GRADES;
				stmt = conn.prepareStatement(query);
				stmt.setInt(1, grade);
				stmt.setString(2, studentId);
				stmt.setString(3, courseId);	
				
				int result = stmt.executeUpdate();
				stmt.close();
				if(result!=0)
					logger.info("Sucessfully updated marks!!");
				else 
				{
					logger.info("Mark updation failed!");
					throw new GradeNotAddedException(courseId,studentId);
				}
				
			}catch(GradeNotAddedException g){
				logger.error("Exception" + g.getMessage());
			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				logger.error("Exception" + e.getMessage());
				return false;
			}
			return true;
				 
			
				
			}
			logger.error("Student does not exist / does not take the course \n");
			return false;
	}

	
	/**
    * {@inheritDoc}
    */ 
	@Override
	public List<Course> showCourses() {
		
		List<Course> courseList =new ArrayList<Course>();
		
			
		try {
			
			String sql=SQLQueriesConstant.COURSE_SELECTION_LIST;
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet courses =  stmt.executeQuery(sql);
			
			while(courses.next()){

				
				 String courseId  = courses.getString("CourseId");
		         String courseName = courses.getString("CourseName");
		         int seatCount = courses.getInt("SeatCount");
		         
		         
		         Course course =new Course();
		         course.setCourseId(courseId);
		         course.setCourseName(courseName);
		         course.setCount(seatCount);

		         courseList.add(course);
		      }
		   
		      stmt.close();
		    // conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error("Exception" + e.getMessage());
		}
		
		 
	  return courseList;    
	  
	}
	
	/**
    * {@inheritDoc}
    */ 
	@Override
	public void viewRegisteredStudents(String id, String courseId) throws StudentNotFoundException{
		try {
			if(isProfCourse( id,  courseId))
				{
					String query = SQLQueriesConstant.VIEW_REGISTERED_STUDENTS;
					stmt = conn.prepareStatement(query);
					stmt.setString(1, courseId);
					ResultSet registeredStudents =  stmt.executeQuery();
						
				
					while(registeredStudents.next()) {
						
						System.out.println("\tStudent Id:"+ registeredStudents.getString("id")+ "\tStudent Name :" + registeredStudents.getString("name"));
						
					   
				    }
					
				
				}
			else{
				logger.error("Professor Not Registered for given Course");
				return ;
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error("Exception" + e.getMessage());
		}
		
		return;
	}
	
	
	/**
	 * Method to check if student and course pair is valid using SQL commands
	 * @param professorId
	 * @param studentId
	 * @param courseId
	 * @return true if valid / false if invalid
	 */
	private boolean checkGradeValidity(String professorId,String studentId, String courseId) {
		// TODO Auto-generated method stub
		try {
			String query = SQLQueriesConstant.CHECK_STUDENT_REGISTRATION_FOR_COURSE;
			stmt = conn.prepareStatement(query);
			stmt.setString(1, studentId);
			stmt.setString(2, courseId);
			ResultSet registeredCourses =  stmt.executeQuery();
		//	List<Course> courseList
		    if(registeredCourses.next()) {
				
				if(isProfCourse( professorId, courseId) ) {
					stmt.close();
				    return true;
				
				}
			   
		    }
		    stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error("Exception" + e.getMessage());
		}
 
	  return false;    
		}
	
	/**
	 * Method to check if grades are to be updated or to be inserted using SQL commands
	 * @param studentId
	 * @param courseId
	 * @return true if to be updated / false if to be inserted
	 */
	private boolean CheckGradeUpdateType(String studentId, String courseId) {
		// TODO Auto-generated method stub
		String query = SQLQueriesConstant.CHECK_GRADE_UPDATE_TYPE;
		try {
			stmt = conn.prepareStatement(query);
			stmt.setString(1, studentId);
			stmt.setString(2, courseId);	
			
			ResultSet grade = stmt.executeQuery();
			
			if(grade.next())
				return true;
			else{
				return false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error("Exception" + e.getMessage());
		}
		
		return false;
	}
	
	/**
	 * Method to check if professor is authorized to change details for a course using SQL commands
	 * @param professorId
	 * @param courseId
	 * @return
	 */
	private boolean isProfCourse(String professorId, String courseId) 
	{
		try {
			
			
			String sql = SQLQueriesConstant.CHECK_PROF_COURSE;
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, professorId);
			stmt.setString(2, courseId);
			ResultSet course =  stmt.executeQuery();
		
				if(course.next()) {
					stmt.close();
				    return true;
				
				}
		
		}catch (SQLException e) {
	// TODO Auto-generated catch block
			logger.error("Exception" + e.getMessage());
		}
	return false;	
	}

	


}
