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
	
	public boolean userLogin(User u);
	public void forgotPassword();
	public void resetPassword();
	public void updateDetails();

}
