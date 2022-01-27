package com.crs.flipkart.business;

import com.crs.flipkart.bean.User;
import com.crs.flipkart.dao.UserDaoInterface;
import com.crs.flipkart.dao.UserDaoOperation;

public class UserService implements UserServiceInterface{
	
	UserDaoInterface userDaoInterface = new UserDaoOperation();
	/*
	 *Method lets user login into the CRS system
	*/	
	public boolean userLogin(User u) {
		// Implement Array struct
		return true;
	}
	/* Method lets user to reset password if forgotten */
	public void forgotPassword() {
		
	}
	/* Method lets user reset password  */
	public void resetPassword() {
		
	}
	/*Method lets user to update its details*/
	public void updateDetails() {
		
	}
    
	/*
	 * Method verifies user using the student table with its id and password 
	 * @param id: id of the user .
	 * @param password: password of the user .
	 */
	public int verifyUser(String id, String password) {
		// TODO Auto-generated method stub
		return userDaoInterface.verifyUser(id,password);
	}
    
	/*Method updates user's password with its id and password*/
	@Override
	public boolean updatePassword(String id, String Password) {
		// TODO Auto-generated method stub
		return userDaoInterface.updatePassword(id,Password);
	}
    /*Method verifies approval using the user id */
	@Override
	public boolean verifyApproval(String id) {
		// TODO Auto-generated method stub
		return userDaoInterface.verifyApproval(id);
	}
	
}
