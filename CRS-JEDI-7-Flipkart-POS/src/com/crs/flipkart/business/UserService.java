package com.crs.flipkart.business;

import org.apache.log4j.Logger;

import com.crs.flipkart.bean.User;
import com.crs.flipkart.dao.UserDaoInterface;
import com.crs.flipkart.dao.UserDaoOperation;

public class UserService implements UserServiceInterface {

	private static Logger logger = Logger.getLogger(UserService.class);
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
		logger.info("Verifying User");
		return userDaoInterface.verifyUser(id, password);
	}

	@Override
	public boolean updatePassword(String id, String Password) {
		// TODO Auto-generated method stub
		logger.info("Updating Password");
		return userDaoInterface.updatePassword(id, Password);
	}

	@Override
	public boolean verifyApproval(String id) {
		// TODO Auto-generated method stub
		logger.info("Verifying Approval");
		return userDaoInterface.verifyApproval(id);
	}

}
