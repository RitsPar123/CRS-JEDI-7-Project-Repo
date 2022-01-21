/**
 * 
 */
package com.crs.flipkart.business;

import java.util.Scanner;

/**
 * @author hardik.kothari
 *
 */
public class OnlinePaymentService {
	
	public void onlineMode()
	{
		System.out.println("Choose mode of payment:");
		System.out.println("1.NetBanking");
		System.out.println("2.UPI");
		System.out.println("3.Card");
		
		Scanner sc = new Scanner(System.in);
		int option = sc.nextInt();
		switch(option)
		{
		case 1:
			
			break;
			
		case 2:
			break;
		case 3:
			break;
		default:
				break;
		}
		
		
	}

}
