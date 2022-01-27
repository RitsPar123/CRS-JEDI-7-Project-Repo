/**
 * 
 */
package com.crs.flipkart.dao;

/**
 * @author Abhinav
 *
 */
public interface UserDaoInterface {
	public int verifyUser(String id,String Password);
	public boolean updatePassword(String id,String Password);
	public boolean verifyApproval(String id);
	
}
