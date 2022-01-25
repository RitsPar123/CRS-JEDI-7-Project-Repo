/**
 * 
 */
package com.crs.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.constants.SQLQueriesConstant;
import com.crs.flipkart.utils.CRSDb;

/**
 * @author Abhinav
 *
 */
public class AdminDaoOperation implements AdminDaoInterface {
	public boolean addCourse(Course course) {
		Connection connection = CRSDb.getConnect();
		
		 try {
				PreparedStatement pstmtCourse = connection.prepareStatement(SQLQueriesConstant.ADD_COURSE);
				
				pstmtCourse.setString(1,course.getCourseId());
				pstmtCourse.setString(2,course.getProfessor());
				pstmtCourse.setString(3,course.getCourseName());
				
				int row = pstmtCourse.executeUpdate();
				
				if(row == 1) return true;

				return false;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.getMessage();
			}finally {
				try {
					connection.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		 return false;
	}
}
