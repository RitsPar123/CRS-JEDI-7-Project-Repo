/**
 * 
 */
package com.crs.flipkart.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;

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
	 Connection conn = CRSDb.getConnect();

	@Override
	public boolean payFees(Payment pay) {
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
	            conn.close();
	            return true;

	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
		  return false;
      
	}


}