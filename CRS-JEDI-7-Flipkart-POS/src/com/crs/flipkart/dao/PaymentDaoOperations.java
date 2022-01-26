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
	
	 Connection conn = CRSDb.getConnect();

	@Override
	public void payFees(Payment pay) {
		  try {
	            
	            PreparedStatement stmt;
	            stmt = conn.prepareStatement(SQLQueriesConstant.ADD_PAYMENT);
	            stmt.setString(1, pay.getStudentId());
	            stmt.setString(2, pay.getPaymentId());
	            stmt.setString(3, pay.getMethod());
	            stmt.setDouble(4, pay.getAmount());
	            stmt.setString(5, pay.getDateOfTransaction());
	            stmt.setBoolean(6, pay.getStatus());
	            

	            stmt.executeUpdate();
	            conn.close();

	           

	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	       
	    

		

      
	}

}
