/**
 * 
 */
package com.crs.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
			
	         pstmt.executeUpdate();

	          System.out.println("Data is Inserted");

	          connection.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		return studentId;
	}
}
