/**
 * 
 */
package com.crs.flipkart.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

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
	        
	        	Properties prop = new Properties();
        /*        InputStream inputStream = CRSDb.class.getClassLoader().getResourceAsStream("./config.properties");
                prop.load(inputStream);
                String driver = prop.getProperty("driver");
                String url = prop.getProperty("url");
                String user = prop.getProperty("user");
                String password = prop.getProperty("password");
*/

                String driver = "com.mysql.jdbc.Driver";
                String url = "jdbc:mysql://localhost:3306/crsdatabase";
                String user = "root";
                String password = "root";





                Class.forName(driver);
	            connection = DriverManager.getConnection(url, user, password);
	            return connection;
	        }
	    }catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	/*	catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
	  */  return connection;
	}
}
