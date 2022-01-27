/**
 * 
 */
package com.crs.flipkart.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;

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

            pstmtP.setString(1, studentId);
            pstmtP.setString(2, message);

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
