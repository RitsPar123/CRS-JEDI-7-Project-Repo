
/**
 * 
 */
package com.crs.flipkart.application;


import java.time.LocalDateTime;
import org.apache.log4j.Logger;
import java.util.Scanner;

import com.crs.flipkart.bean.CourseCatalog;
import com.crs.flipkart.business.NotificationService;
import com.crs.flipkart.business.NotificationServiceInterface;
import com.crs.flipkart.business.StudentService;
import com.crs.flipkart.business.StudentServiceInterface;
import com.crs.flipkart.business.UserService;
import com.crs.flipkart.business.UserServiceInterface;

/**
 * @author Abhinav
 *
 */
public class CRSApplication {

    /**
     * @param args
     */

    static UserServiceInterface userInterface = new UserService();
    static StudentApplication studentApplication = new StudentApplication();
    static Scanner sc = new Scanner(System.in);
    private static Logger logger = Logger.getLogger(CRSApplication.class);

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        menu();
        
        int userInput = sc.nextInt();
        while (userInput != 4) {
            switch (userInput) {
                case 1:
                    // login
                    CRSApplication.loginUser();
                    break;
                case 2:
                    // student registration
                    CRSApplication.registerStudent();
                    break;
                case 3:
                	// update Password
                    CRSApplication.updatePassword();
                    break;
                default:
                	logger.info("Invalid Input");
            }
            menu();
            userInput = sc.nextInt();
        }
    }

    public static void menu() {
    	logger.info("----------Welcome to Course Management System---------");
        logger.info("1. Login");
        logger.info("2. Student Registration");
        logger.info("3. UpdatePassword");
        logger.info("4. Exit");
        logger.info("Enter user input");
    }

    public static void registerStudent() {

        logger.info("Enter Id:");
        String id = sc.next();

        logger.info("Enter Name:");
        String name = sc.next();

        logger.info("Enter Password:");
        String password = sc.next();

        logger.info("Enter Branch:");
        String branch = sc.next();
        
        int role = 1;

        StudentServiceInterface studentInterface = new StudentService();

        String newUserID = studentInterface.signup(id, password, branch, name, role);
        
        logger.info("Thankyou For Registration, Wait for the Admin Approval");
    	
    }

    public static void loginUser() {
        String id, password;

        logger.info("-----------------Login Menu------------------");

        logger.info("Enter id ");
        id = sc.next();

        logger.info("Enter password");
        password = sc.next();

        int loggedIn = -1;

        loggedIn = userInterface.verifyUser(id, password);

        if (loggedIn ==1 || loggedIn == 2 || loggedIn == 3) {
        	LocalDateTime localDateTime = LocalDateTime.now(); 
			 
            switch (loggedIn) {
                // Student
                case 1: {
                	boolean isApproved = userInterface.verifyApproval(id);
                	if(isApproved) {
                		logger.info("Student Has Logged In at : " + localDateTime + " ->  Login Successful");
                        StudentApplication studentApp = new StudentApplication();
                        studentApp.studentLoggedin(id);
                	}else {
                		logger.warn("Failed to login, you have not been approved by the administration!");
                	}
                    
                }
                    break;
                    
                case 2:
                	logger.info("Professor Has Logged In at : " + localDateTime + " ->  Login Successful");
                    ProfessorApplication professorApplication = new ProfessorApplication();
					professorApplication.professorLoggedIn(id);
                    break;
                    
                case 3:
                	logger.info("Admin Has Logged In at : " + localDateTime + " ->  Login Successful");
                    AdminApplication adminCRS = new AdminApplication();
                    adminCRS.showMenu();
                    break;
            }
        }else {
				logger.error("Invalid Credentials!");
        }
    }
    
    public static void updatePassword() {
    	String id, password;
    	try {
        logger.info("Enter id ");
        id = sc.next();

        logger.info("Enter New Password");
        password = sc.next();
        
        boolean isUpdated = false;
        
        isUpdated = userInterface.updatePassword(id,password);
        
        if(isUpdated) 
        	logger.info("Password Updated Successfully");
        else
        	logger.error("Not Updated");
    	}
    	catch(Exception e){
    		logger.error("Error Occured "+e.getMessage());
    	}
    }

}
