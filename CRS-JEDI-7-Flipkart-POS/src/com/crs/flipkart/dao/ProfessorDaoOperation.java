/**
 * 
 */
package com.crs.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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
		return false;
	}

	@Override
	public List<Course> viewRegisteredCourses(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addGrades(String courseId, String studentId, int grade) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Course> showCourses() {
		
		
			
		try {
			
			String sql="select * from course where pid is null";
			ResultSet courses =  stmt.executeQuery(sql);
		//	List<Course> courseList
			
			while(courses.next()){
		         //Retrieve by column name
		         int eid  = courses.getInt("id");
		         String name1 = courses.getString("name");
		         String address1 = courses.getString("adress");
		         String location1 = courses.getString("location");

		         //Display values
		         System.out.print("ID: " + eid);
		         System.out.print(", Age: " + name1);
		         System.out.print(", First: " + address1);
		         System.out.println(", Last: " + location1);
		      }
		   
		      stmt.close();
		      conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 
	  return null;    
	  
	}

}
