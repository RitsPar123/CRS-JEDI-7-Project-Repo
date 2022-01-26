/**
 * 
 */
package com.crs.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.crs.flipkart.constants.SQLQueriesConstant;
import com.crs.flipkart.utils.CRSDb;

/**
 * @author Abhinav
 *
 */
public class UserDaoOperation implements UserDaoInterface {

	@Override
	public int verifyUser(String id, String Password) {
		// TODO Auto-generated method stub
		
		Connection connection = CRSDb.getConnect();
		
		 try {
				PreparedStatement pstmt = connection.prepareStatement(SQLQueriesConstant.VERIFY_USER);
				
				pstmt.setString(1,id);
				
				ResultSet result = pstmt.executeQuery();
				
				if(!result.next()) {
					System.out.println("jvndx");
				}
				
				else if(Password.equals(result.getString("Password"))) {
					return result.getInt("Role");
				}
				else {
					return 4;
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

}
