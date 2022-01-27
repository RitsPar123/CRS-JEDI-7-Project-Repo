/**
 * 
 */
package com.crs.flipkart.business;

import com.crs.flipkart.bean.User;

/**
 * @author hardik.kothari
 *
 */

 /*
  *Interface consists of various methods of User related to login,password and approval
  *
  */
public interface UserServiceInterface {
	
	public int verifyUser(String id,String Password);
	public boolean userLogin(User u);
	public boolean updatePassword(String id,String Password);
	public void forgotPassword();
	public void resetPassword();
	public void updateDetails();
	public boolean verifyApproval(String id);

}
