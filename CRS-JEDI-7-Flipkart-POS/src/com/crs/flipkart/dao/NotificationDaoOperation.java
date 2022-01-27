/**
 * 
 */
package com.crs.flipkart.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.UUID;

import com.crs.flipkart.constants.SQLQueriesConstant;
import com.crs.flipkart.utils.CRSDb;

/**
 * @author Abhinav
 *
 */
public class NotificationDaoOperation implements NotificationDaoInterface {

	@Override
	public boolean sendNotification(String studentId, String message) {
		// TODO Auto-generated method stub

		Connection conn = CRSDb.getConnect();
        try {
            PreparedStatement pstmtP;
            pstmtP = conn.prepareStatement(SQLQueriesConstant.SET_NOTIFICATION);
            
            UUID uuid=UUID.randomUUID();   
            String uuidAsString = uuid.toString();     
            
            pstmtP.setString(1, uuidAsString);
            pstmtP.setString(2, studentId);
            pstmtP.setString(3, message);

            pstmtP.executeUpdate();
            //conn.close();

            return true;

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

		return false;
	}
	

}
