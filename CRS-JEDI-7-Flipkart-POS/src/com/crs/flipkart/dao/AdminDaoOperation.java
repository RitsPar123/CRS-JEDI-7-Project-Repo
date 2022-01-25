/**
 * 
 */
package com.crs.flipkart.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Professor;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.constants.SQLQueriesConstant;
import com.crs.flipkart.utils.CRSDb;

/**
 * @author Abhinav
 *
 */
public class AdminDaoOperation implements AdminDaoInterface {
	Connection conn = CRSDb.getConnect();
	
	public boolean addCourse(Course course) {
		try {
//				Connection conn = CRSDb.getConnect();
			    PreparedStatement stmt;
				stmt = conn.prepareStatement(SQLQueriesConstant.ADD_COURSE);
				stmt.setString(1,course.getCourseId());
				stmt.setString(2,course.getProfessor());
				stmt.setString(3,course.getCourseName());
		
				stmt.executeUpdate();
				conn.close();
				
				return true;
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		 return false;
	}

	@Override
	public boolean deleteCourse(String id) {
		// TODO Auto-generated method stub
		
		try {
			PreparedStatement stmt;
			stmt = conn.prepareStatement(SQLQueriesConstant.DELETE_COURSE);
			stmt.setString(1, id);
			
			int row = stmt.executeUpdate();
			conn.close();
			
			return true;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean addProfessor(Professor professor) {
		// TODO Auto-generated method stub
        try {
        	PreparedStatement pstmtP;
        	pstmtP = conn.prepareStatement(SQLQueriesConstant.ADD_PROFESSOR);
			
			pstmtP.setString(1,professor.getId());
			pstmtP.setString(2,professor.getDepartment());
			
	        pstmtP.executeUpdate();

	        conn.close();
	        
	        return true;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		return false;
	}

	@Override
	public boolean approveStudent(String SId) {
		// TODO Auto-generated method stub
		Connection conn = CRSDb.getConnect();
		try {
        	PreparedStatement pstmtP;
        	pstmtP = conn.prepareStatement(SQLQueriesConstant.APPROVE_STUDENT);
			
			pstmtP.setString(1,SId);
		
	        pstmtP.executeUpdate();
	        conn.close();
	        
	        return true;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		return false;
	}

	@Override
	public List<Student> viewPendingApproval() {
		// TODO Auto-generated method stub
		Connection conn = CRSDb.getConnect();
		try {
        	PreparedStatement pstmtP;
        	pstmtP = conn.prepareStatement(SQLQueriesConstant.PENDING_STUDENT);
        	
        	ResultSet resultSet = pstmtP.executeQuery();
        			
        	List<Student> studentList =  new ArrayList<Student>();
        	while(resultSet.next()) {
        		Student stud = new Student();
        		stud.setId(resultSet.getString(1));
        		stud.setBranch(resultSet.getString("Branch"));
        		
        		studentList.add(stud);
        	}
	
	        conn.close();
	        
	        return studentList;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	}

