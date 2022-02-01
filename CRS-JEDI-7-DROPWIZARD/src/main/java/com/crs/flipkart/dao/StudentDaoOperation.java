/**
 * 
 */
package com.crs.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.crs.flipkart.bean.Student;
import com.crs.flipkart.constants.SQLQueriesConstant;
import com.crs.flipkart.exception.StudentNotFoundException;
import com.crs.flipkart.utils.CRSDb;

/**
 * @author Abhinav
 *
 */
public class StudentDaoOperation implements StudentDaoInterface {
	
	
	private static Logger logger = Logger.getLogger(StudentDaoOperation.class);

	/**
	 * {@inheritDoc}
	 */
	public boolean signup(Student student) {
		
		Connection connection = CRSDb.getConnect();
		
		String studentId = null;

        try {
			PreparedStatement pstmt = connection.prepareStatement(SQLQueriesConstant.ADD_USER);
			
			pstmt.setString(1,student.getId());
			pstmt.setString(2,student.getUserName());
			pstmt.setString(3,student.getPassword());
			pstmt.setInt(4,1);
			
	        int result = pstmt.executeUpdate();

	        if(result == 1) {
	        	PreparedStatement pstmtStudent;
	        	pstmtStudent = connection.prepareStatement(SQLQueriesConstant.ADD_STUDENT);
				
				pstmtStudent.setString(1,student.getId());
				pstmtStudent.setString(2,student.getBranch());
				
		        int result2 = pstmtStudent.executeUpdate();
		        
		        if(result2 == 1) {
		        	studentId = student.getId();
		        	logger.info("Student has signed up");

		        }
				else{
					throw new StudentNotFoundException(student.getId());
				}
	        }
	        return true;
			
		}catch(StudentNotFoundException u){
			logger.error("Exception" + u.getMessage());
		}
		 catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("Exception" + e.getMessage());
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				logger.error("Exception" + e.getMessage());
			}
		}
        
		return false;
	}

	
	/**
	 * {@inheritDoc}
	 */
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
			     registrationStatus=resultSet.getInt("IsRegistered");
			}
			else{
				throw new StudentNotFoundException(id);
			}
		}catch(StudentNotFoundException u){
			logger.error("Exception" + u.getMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("Exception" + e.getMessage());
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				logger.error("Exception" + e.getMessage());
			}
		}
		return registrationStatus;	
	}
	
}
