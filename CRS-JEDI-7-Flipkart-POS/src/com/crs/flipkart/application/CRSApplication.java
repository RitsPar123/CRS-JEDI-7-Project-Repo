/**
 * 
 */
package com.crs.flipkart.application;

import java.util.Scanner;

import com.crs.flipkart.bean.Student;
import com.crs.flipkart.bean.User;
import com.crs.flipkart.business.StudentService;
import com.crs.flipkart.business.UserService;

/**
 * @author harsh
 *
 */
public class CRSApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String id,password;
		System.out.println("Login Menu");
		System.out.println("Enter id ");
		Scanner sc = new Scanner(System.in);
		id = sc.next();
		System.out.println("Enter password");
		password = sc.next();
		
		User u = new User(id,password);
		UserService c = new UserService();
		
		if(c.userLogin(u)) {
			while(true) {
				switch (u.getRole()) {
					case 1: 
						// Student
						break;
					case 2: 
						// Professor
						break;
					case 3: 
						// Admin
						break;
				}
				System.out.println("Want to logout? Y N");
				char ans = sc.next().charAt(0);
				if(ans == 'Y') break;
			}
		}
		
		System.out.println("Session ended");
		
	}

}
