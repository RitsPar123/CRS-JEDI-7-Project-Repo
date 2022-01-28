/**
 * 
 */
package com.crs.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.crs.flipkart.constants.SQLQueriesConstant;
import com.crs.flipkart.utils.CRSDb;

/**
 * @author Abhinav
 *
 */
public class UserDaoOperation implements UserDaoInterface {

	 private static Logger logger = Logger.getLogger(StudentDaoOperation.class);

	@Override
	public int verifyUser(String id, String Password) {
		// TODO Auto-generated method stub
		
		Connection connection = CRSDb.getConnect();
		
		 try {
				PreparedStatement pstmt = connection.prepareStatement(SQLQueriesConstant.VERIFY_USER);
				
				pstmt.setString(1,id);
				
				ResultSet result = pstmt.executeQuery();
				
				if(!result.next()) {
					logger.error("User Not Verified");
				}
				
				else if(Password.equals(result.getString("Password"))) {
					logger.info("User Verified");
					return result.getInt("Role");
				}
				else {
					return 4;
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				logger.error("Exception" + e.getMessage());
			}
		 
		return 4;
	}

	@Override
	public boolean updatePassword(String id, String Password) {
		// TODO Auto-generated method stub
		Connection connection = CRSDb.getConnect();
		
		try {
			PreparedStatement pstmtUpdate = connection.prepareStatement(SQLQueriesConstant.UPDATE_PASSWORD);
			
			pstmtUpdate.setString(1,Password);
			pstmtUpdate.setString(2,id);
			
			int result = pstmtUpdate.executeUpdate();
			
			if(result == 1) 
			{
				logger.info("Password Updated");
				return true;
			}
			return false;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("Exception" + e.getMessage());
		}
		
		return false;
	}

	@Override
	public boolean verifyApproval(String id) {
		// TODO Auto-generated method stub
		
		Connection connection = CRSDb.getConnect();
		
		try {
			PreparedStatement pstmtUpdate = connection.prepareStatement(SQLQueriesConstant.VERIFY_APPROVAL);
			
			pstmtUpdate.setString(1,id);
			
			ResultSet resultSet = pstmtUpdate.executeQuery();
			Boolean isApproved = false;
			
			if(resultSet.next()) 
				isApproved = resultSet.getBoolean("IsApproved");
			
			if(isApproved == true) return true;
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("Exception" + e.getMessage());
		}
		
		return false;
	}

}
