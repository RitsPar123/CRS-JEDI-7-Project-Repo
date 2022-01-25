/**
 * 
 */
package com.crs.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Professor;
import com.crs.flipkart.constants.SQLQueriesConstant;
import com.crs.flipkart.utils.CRSDb;

/**
 * @author Abhinav
 *
 */
public class AdminDaoOperation implements AdminDaoInterface {
	
	public boolean addCourse(Course course) {
		Connection conn = CRSDb.getConnect();
		try {
			    PreparedStatement stmt;
				stmt = conn.prepareStatement(SQLQueriesConstant.ADD_COURSE);
				stmt.setString(1,course.getCourseId());
				stmt.setString(2,course.getProfessor());
				stmt.setString(3,course.getCourseName());

				return stmt.executeUpdate() == 1;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		 return false;
	}

	@Override
	public boolean deleteCourse(String id) {
		// TODO Auto-generated method stub
		Connection conn = CRSDb.getConnect();
		try {
			PreparedStatement stmt;
			stmt = conn.prepareStatement(SQLQueriesConstant.DELETE_COURSE);
			stmt.setString(1, id);
			
			int row = stmt.executeUpdate();
			
			if(row == 1) {
				return true;
			}
			
			return false;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public boolean addProfessor(Professor professor) {
		// TODO Auto-generated method stub
		Connection conn = CRSDb.getConnect();
        try {
        	PreparedStatement pstmtP;
        	pstmtP = conn.prepareStatement(SQLQueriesConstant.ADD_PROFESSOR);
			
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
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
        
		return false;
	}

	@Override
	public void approveStudent(String SId) {
		// TODO Auto-generated method stub
		Connection conn = CRSDb.getConnect();
		try {
        	PreparedStatement pstmtP;
        	pstmtP = conn.prepareStatement(SQLQueriesConstant.APPROVE_STUDENT);
			
			pstmtP.setString(1,SId);
		
	        int result = pstmtP.executeUpdate();

	        if(result == 1)
	        	return;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
        
		return;
	}
	}

