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

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Professor;
import com.crs.flipkart.constants.SQLQueriesConstant;
import com.crs.flipkart.utils.CRSDb;

/**
 * @author Abhinav
 *
 */
public class AdminDaoOperation implements AdminDaoInterface {
	
	Connection connection = CRSDb.getConnect();
	
	public boolean addCourse(Course course) {
		
		Connection connection = CRSDb.getConnect();
		try {
			   if(connection!=null) System.out.println("vsdvsdc");
				PreparedStatement pstmtCourse = connection.prepareStatement(SQLQueriesConstant.ADD_COURSE);
				System.out.println(course.getCourseId()+" gdfgetrgtgtr "+course.getProfessor() + " "+course.getCourseName());
				pstmtCourse.setString(1,course.getCourseId());
				pstmtCourse.setString(2,course.getProfessor());
				pstmtCourse.setString(3,course.getCourseName());
				System.out.println(course.getCourseId()+" "+course.getProfessor() + " "+course.getCourseName());
//				int row = pstmtCourse.executeUpdate();
//				
//				if(row == 1) return true;
//
//				return false;
				return pstmtCourse.executeUpdate() == 1;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.getMessage();
			}
		 return false;
	}

	@Override
	public boolean deleteCourse(String id) {
		// TODO Auto-generated method stub
		
		try {
			PreparedStatement pstmtCourseD = connection.prepareStatement(SQLQueriesConstant.DELETE_COURSE);
			
			pstmtCourseD.setString(1, id);
			
			int row = pstmtCourseD.executeUpdate();
			
			if(row == 1) {
				return true;
			}
			
			return false;
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public boolean addProfessor(Professor professor) {
		// TODO Auto-generated method stub
		Connection connection = CRSDb.getConnect();

        try {
			PreparedStatement pstmtP = connection.prepareStatement(SQLQueriesConstant.ADD_PROFESSOR);
			
			pstmtP.setString(1,professor.getId());
			pstmtP.setString(2,professor.getDepartment());
			
	        int result = pstmtP.executeUpdate();

	        if(result == 1)
	        	return true;
	        
	        return false;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
        
		return false;
	}
	
	public List<Course> getAllCourse() {
		List<Course> courses = new ArrayList<>();
		
		Connection connection = CRSDb.getConnect();
		
		try {
			
			PreparedStatement pstmt = connection.prepareStatement("");
			
			ResultSet resultSet = pstmt.executeQuery();
			
			while(resultSet.next()) {
				Course course = new Course();
				course.setCourseId(resultSet.getString(0));
				course.setProfessor(resultSet.getString(1));
				course.setCourseName(resultSet.getString(2));
				courses.add(course);
			}
			
			return courses;
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return courses;
	}
	
}

