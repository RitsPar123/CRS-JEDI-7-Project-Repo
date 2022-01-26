/**
 * 
 */
package com.crs.flipkart.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Abhinav
 *
 */
public class CRSDb {
	private static Connection connection = null;
	
	public static Connection getConnect() {
		
		try {
	        if (connection != null && !connection.isClosed()) {
	            return connection;
	        } else {
	        	Class.forName("com.mysql.jdbc.Driver");
	            String url = "jdbc:mysql://localhost:3306/crsdatabase";
	            String username = "root";
	            String password = "root";
	            connection = DriverManager.getConnection(url, username, password);
	        }
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return connection;
	}
}
