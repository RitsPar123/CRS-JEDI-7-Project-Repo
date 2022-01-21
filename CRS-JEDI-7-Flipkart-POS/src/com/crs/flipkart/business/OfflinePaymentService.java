package com.crs.flipkart.business;

import java.util.Scanner;

public class OfflinePaymentService {
	
	public void offlineMode()
	{
		System.out.println("Choose mode of Offlline payment:");
		System.out.println("1.Cash");
		System.out.println("2.Cheque");
		Scanner sc = new Scanner(System.in);
		int option = sc.nextInt();
		
		switch(option)
		{
		case 1:
			break;
			
		case 2:
			break;
		default:
				break;
		}
	}

}
