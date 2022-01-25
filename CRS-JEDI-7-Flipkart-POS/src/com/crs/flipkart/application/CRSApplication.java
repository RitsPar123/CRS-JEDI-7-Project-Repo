
/**
 * 
 */
package com.crs.flipkart.application;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.CourseCatalog;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.bean.User;
import com.crs.flipkart.business.CourseCatalogService;
import com.crs.flipkart.business.CourseCatalogServiceInterface;
import com.crs.flipkart.business.StudentService;
import com.crs.flipkart.business.StudentServiceInterface;
import com.crs.flipkart.business.UserService;
import com.crs.flipkart.business.UserServiceInterface;

/**
 * @author harsh
 *
 */
public class CRSApplication {

    /**
     * @param args
     */

    static UserServiceInterface userInterface = new UserService();
    static CourseCatalog courseCatalog = new CourseCatalog();
    static StudentApplication studentApplication = new StudentApplication();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // TODO Auto-generated method stub


        Scanner sc = new Scanner(System.in);
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
                    System.out.println("Invalid Input");
            }
            menu();
            userInput = sc.nextInt();
        }
    }

    public static void menu() {
        System.out.println("----------Welcome to Course Management System---------");
        System.out.println("1. Login");
        System.out.println("2. Student Registration");
        System.out.println("3. UpdatePassword");
        System.out.println("4. Exit");
        System.out.println("Enter user input");
    }

    public static void registerStudent() {

        System.out.println("Enter Id:");
        String id = sc.next();

        System.out.println("Enter Name:");
        String name = sc.next();

        System.out.println("Enter Password:");
        String password = sc.next();

        System.out.println("Enter Branch:");
        String branch = sc.next();
        int role = 1;

        StudentServiceInterface studentInterface = new StudentService();

        String newUserID = studentInterface.signup(id, password, branch, name, role);

    }

    public static void loginUser() {
        String id, password;

        System.out.println("-----------------Login Menu------------------");

        System.out.println("Enter id ");
        id = sc.next();

        System.out.println("Enter password");
        password = sc.next();

        int loggedIn = -1;

        loggedIn = userInterface.verifyUser(id, password);

        if (loggedIn ==1 || loggedIn == 2 || loggedIn == 3) {

            switch (loggedIn) {
                // Student
                case 1: {
                    StudentApplication studentApp = new StudentApplication();
                    studentApp.studentLoggedin(id,courseCatalog);
                }
                    break;
                case 2:
                    System.out.println("Professor");
                    break;
                case 3:
                    AdminApplication adminCRS = new AdminApplication();
                    adminCRS.showMenu();
                    break;
            }
        }
    }
    
    public static void updatePassword() {
    	String id, password;
        System.out.println("Enter id ");
        id = sc.next();

        System.out.println("Enter New Password");
        password = sc.next();
        
        boolean isUpdated = false;
        
        isUpdated = userInterface.updatePassword(id,password);
        
        if(isUpdated) 
        	System.out.println("Password Updated Successfully");
        else
        	System.out.println("Not Updated");
    }

}
