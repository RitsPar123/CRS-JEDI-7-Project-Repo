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

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.utils.CRSDb;

/**
 * @author Abhinav
 *
 */
public class ProfessorDaoOperation implements ProfessorDaoInterface {
	
	Connection conn = CRSDb.getConnect();
	PreparedStatement stmt = null;

	@Override
	public boolean selectCourse(String profId,String courseid, String coursename) {
		// TODO Auto-generated method stub
		try {
			
			String query = "update course set PID = ? where courseID = ? and courseName = ? and PID is null";
			stmt = conn.prepareStatement(query);
			stmt.setString(1, profId);
			stmt.setString(2, courseid);
			stmt.setString(3, coursename);
		//	stmt.setString(4, "aaaa");
			
			int result = stmt.executeUpdate();
			
			if(result==0) 
			{
				System.out.println("Course does not exist or already been taken");
				return false;
				}
			else 
			{
				System.out.println("Course has been added Successfully");
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	
	@Override
	public List<Course> viewRegisteredCourses(String id) {
		// TODO Auto-generated method stub
		
		List<Course> RegisteredCourses = new ArrayList<Course>();
		
		try {
			
				String sql="select CourseId, CourseName from course where PId = ? ";
				
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
			e.printStackTrace();
			
		}
		return RegisteredCourses;
}


	@Override
	public boolean addGrades(String professorId, String courseId, String studentId, int grade) {
		String query;
		if(checkGradeValidity(professorId,studentId,courseId)) {
			
			if(CheckGradeUpdateType(studentId , courseId)) {
				
				System.out.println("Record already exists\n");
				System.out.print("Press Y if you want to overwrite :  ");
				Scanner sc = new Scanner(System.in);
				String choice = sc.next();
				System.out.println();
				
				if(choice.equalsIgnoreCase("Y")) {
					try {
						query = "UPDATE grade SET marks = ? where sId = ? and courseId = ? LIMIT 1";
						stmt = conn.prepareStatement(query);
						stmt.setInt(1, grade);
						stmt.setString(2, studentId);
						stmt.setString(3, courseId);	
						
						int result = stmt.executeUpdate();
						stmt.close();
						if(result!=0)
							System.out.println("Sucessfully updated marks!!");
						else 
							System.out.println("Mark updation failed!");
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						return false;
					}
					return true;
				}
				System.out.println("Mark updation cancelled");
				return true;
			}
				 
				query = "Insert into grade values (?,?,?)";
				
				try {
			
					stmt = conn.prepareStatement(query);
					stmt.setString(1, studentId);
					stmt.setString(2, courseId);	
					stmt.setInt(3, grade);
					
					stmt.execute();
					System.out.println("Sucessfully updated marks!!");
					return true;
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return false;
				}
				
			}
			System.out.println("Student does not exist / does not take the course \n");
			return false;
	}

	
	
	
	@Override
	public List<Course> showCourses() {
		
		List<Course> courseList =new ArrayList<Course>();
		
			
		try {
			
			String sql="Select CourseId,courseName,seatCount from course where pid is null";
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
			e.printStackTrace();
		}
		
		 
	  return courseList;    
	  
	}
	
	@Override
	public void viewRegisteredStudents(String id, String courseId) {
		try {
			if(isProfCourse( id,  courseId))
				{
					String query = "Select user.id ,user.name from (user INNER JOIN registeredcourse ON registeredcourse.sid = user.id ) where courseid = ? and IsRegistered = 2";
					stmt = conn.prepareStatement(query);
					stmt.setString(1, courseId);
					ResultSet registeredStudents =  stmt.executeQuery();
		
					while(registeredStudents.next()) {
						
						System.out.println("\tStudent Id:"+ registeredStudents.getString("id")+ "\tStudent Name :" + registeredStudents.getString("name"));
						
					   
				    }
					return ;
				}
			else{
				System.out.println("Professor Not Registered for given Course");
				return ;
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return;
	}
	
	
	
	private boolean checkGradeValidity(String professorId,String studentId, String courseId) {
		// TODO Auto-generated method stub
		try {
			String query = "select * from registeredcourse where sid = ? and courseid = ? and IsRegistered = 2";
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
			e.printStackTrace();
		}
 
	  return false;    
		}
	
	
	private boolean CheckGradeUpdateType(String studentId, String courseId) {
		// TODO Auto-generated method stub
		String query = "select * from grade where sid = ? and courseid = ?";
		try {
			stmt = conn.prepareStatement(query);
			stmt.setString(1, studentId);
			stmt.setString(2, courseId);	
			
			ResultSet grade = stmt.executeQuery();
			
			if(grade.next())
				return true;
			else
				return false;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	private boolean isProfCourse(String professorId, String courseId) 
	{
		try {
			
			
			String sql = "select * from course where pid = ? and courseid = ? ";
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
			e.printStackTrace();
		}
	return false;	
	}

	


}
