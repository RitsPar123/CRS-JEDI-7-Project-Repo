/**
 * 
 */
package com.crs.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.crs.flipkart.bean.Student;
import com.crs.flipkart.constants.SQLQueriesConstant;
import com.crs.flipkart.utils.CRSDb;

/**
 * @author Abhinav
 *
 */
public class StudentDaoOperation implements StudentDaoInterface {
	public String signup(Student student) {
		
		Connection connection = CRSDb.getConnect();
		
		String studentId = null;

        try {
			PreparedStatement pstmt = connection.prepareStatement(SQLQueriesConstant.ADD_USER);
			
			pstmt.setString(1,student.getId());
			pstmt.setString(2,student.getUserName());
			pstmt.setString(3,student.getPassword());
			pstmt.setInt(4,student.getRole());
			
	        int result = pstmt.executeUpdate();

	        if(result == 1) {
	        	PreparedStatement pstmtStudent;
	        	pstmtStudent = connection.prepareStatement(SQLQueriesConstant.ADD_STUDENT);
				
				pstmtStudent.setString(1,student.getId());
				pstmtStudent.setString(2,student.getBranch());
				
		        int result2 = pstmtStudent.executeUpdate();
		        
		        if(result2 == 1) {
		        	studentId = student.getId();
		        }

	        }
			
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
        
		return studentId;
	}
	
	
	public int getRegistrationStatus(String id) {
		Connection connection = CRSDb.getConnect();
		
		int registrationStatus = 0;

        try {
			PreparedStatement pstmt = connection.prepareStatement(SQLQueriesConstant.GET_REGISTRATION_STATUS);
			// TODO: GET REGISTRATION STATUS
			// AND UPDATE registrationStatus
			pstmt.setString(1,id);
			
			ResultSet resultSet = pstmt.executeQuery();
			if(resultSet.next())
			{
			     registrationStatus=resultSet.getInt(0);
			}
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
		return registrationStatus;	
	}
	
}
