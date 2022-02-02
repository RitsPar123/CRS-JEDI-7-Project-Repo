/**
 * 
 */
package com.crs.flipkart.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;

import org.apache.log4j.Logger;

import com.crs.flipkart.constants.SQLQueriesConstant;
import com.crs.flipkart.utils.CRSDb;
import com.crs.flipkart.bean.Payment;


/**
 * @author nandini mehta
 *
 */
public class PaymentDaoOperations implements PaymentDaoInterface {
	java.util.Date date=new java.util.Date();
	java.sql.Date sqlDate=new java.sql.Date(date.getTime());
	 
	 private static Logger logger = Logger.getLogger(PaymentDaoOperations.class);

	/**
    * {@inheritDoc}
    */  
	@Override
	public boolean payFees(Payment pay) {
			Connection conn = CRSDb.getConnect();
		  try {
			    date = new java.util.Date();
	            PreparedStatement stmt;
	            stmt = conn.prepareStatement(SQLQueriesConstant.ADD_PAYMENT);
	            stmt.setString(1, pay.getStudentId());
	            stmt.setString(2, pay.getPaymentId());
	            stmt.setString(3, pay.getPaymentMethod());
	            stmt.setDouble(4, pay.getAmount());
	            stmt.setDate(5, sqlDate);
	          
	            stmt.executeUpdate();
//	            conn.close();
	            logger.info("Fee Payment Done");
	            return true;

	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	        	logger.error("Exception" + e.getMessage());
	        }
		  return false;
      
	}


}