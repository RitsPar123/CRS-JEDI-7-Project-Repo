/**
 * 
 */
package com.crs.flipkart.business;

import com.crs.flipkart.bean.User;

/**
 * @author hardik.kothari
 *
 */
public interface UserServiceInterface {
	
	public int verifyUser(String id,String Password);
	public boolean userLogin(User u);
	public boolean updatePassword(String id,String Password);
	public void forgotPassword();
	public void resetPassword();
	public void updateDetails();

}
