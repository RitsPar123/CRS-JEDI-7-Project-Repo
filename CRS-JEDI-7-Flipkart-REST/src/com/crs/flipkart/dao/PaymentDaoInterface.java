/**
 * 
 */
package com.crs.flipkart.dao;
import java.util.*;
import com.crs.flipkart.bean.Payment;
/**
 * @author nandini mehta
 *
 */
public interface PaymentDaoInterface {
	
	/**
	 * Method to insert payment details to DB using SQL commands
	 * @param pay
	 * @return true if insert successful / false if failure
	 */
	public boolean payFees(Payment pay);
	

}
