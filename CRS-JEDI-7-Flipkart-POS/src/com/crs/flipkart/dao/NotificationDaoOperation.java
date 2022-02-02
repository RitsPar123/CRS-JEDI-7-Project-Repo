/**
 * 
 */
package com.crs.flipkart.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;

import com.crs.flipkart.bean.Notification;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.constants.SQLQueriesConstant;
import com.crs.flipkart.utils.CRSDb;

/**
 * @author Abhinav
 *
 */
public class NotificationDaoOperation implements NotificationDaoInterface {

	
	private static Logger logger = Logger.getLogger(NotificationDaoOperation.class);

    /**
    * {@inheritDoc}
    */  
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
            logger.info("Notification Sent");
            return true;

        } catch (SQLException e) {
            // TODO Auto-generated catch block
        	logger.error("Exception" + e.getMessage());
        }

		return false;
	}

	@Override
	public List<Notification> getNoti(String id){
		// TODO Auto-generated method stub
		  Connection conn = CRSDb.getConnect();
	        try {
	            PreparedStatement pstmtP;
	            pstmtP = conn.prepareStatement(SQLQueriesConstant.NOTIFICATION_STUDENT);

	            pstmtP.setString(1, id);
	            
	            ResultSet resultSet = pstmtP.executeQuery();
	       

	            List<Notification> notificationList = new ArrayList<Notification>();
	          
		            while (resultSet.next()) {
		                Notification noti = new Notification();
		                noti.setMessage(resultSet.getString(1));
	
		                notificationList.add(noti);
		            }

	            //conn.close();
	            return notificationList;
	            
	            
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	        	logger.error("Exception" + e.getMessage());
	        }
		return null;
	}
	

}
