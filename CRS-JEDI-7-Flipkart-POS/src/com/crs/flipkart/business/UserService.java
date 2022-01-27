package com.crs.flipkart.business;

import com.crs.flipkart.bean.User;
import com.crs.flipkart.dao.UserDaoInterface;
import com.crs.flipkart.dao.UserDaoOperation;

public class UserService implements UserServiceInterface{
	
	UserDaoInterface userDaoInterface = new UserDaoOperation();
	
	public boolean userLogin(User u) {
		// Implement Array struct
		return true;
	}
	
	public void forgotPassword() {
		
	}
	
	public void resetPassword() {
		
	}
	
	public void updateDetails() {
		
	}

	public int verifyUser(String id, String password) {
		// TODO Auto-generated method stub
		return userDaoInterface.verifyUser(id,password);
	}

	@Override
	public boolean updatePassword(String id, String Password) {
		// TODO Auto-generated method stub
		return userDaoInterface.updatePassword(id,Password);
	}

	@Override
	public boolean verifyApproval(String id) {
		// TODO Auto-generated method stub
		return userDaoInterface.verifyApproval(id);
	}
	
}
