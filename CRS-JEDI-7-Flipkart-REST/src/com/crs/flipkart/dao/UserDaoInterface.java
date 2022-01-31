/**
 * 
 */
package com.crs.flipkart.dao;

/**
 * @author Abhinav
 *
 */
public interface UserDaoInterface {

	/**
	 * Method to verify if user credentials are valid using SQL commands
	 * @param id
	 * @param Password
	 * @return role(3-admin, 2-professor, 1-student) / 4 if wrong credentials
	 */
	public int verifyUser(String id,String Password);

	/**
	 * Method to update password using SQL commands
	 * @param id
	 * @param Password
	 * @return true if successful / false if failure
	 */
	public boolean updatePassword(String id,String Password);

	/**
	 * Method to see if user is approved using SQL commands
	 * @param id
	 * @return true if approved / false if not approved
	 */
	public boolean verifyApproval(String id);
	
}
