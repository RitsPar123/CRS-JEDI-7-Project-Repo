package com.crs.flipkart.business;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.crs.flipkart.bean.CashPayment;
import com.crs.flipkart.bean.ChequePayment;
import com.crs.flipkart.bean.OfflinePayment;

public class OfflinePaymentService {
	
	private static Logger logger = Logger.getLogger(OfflinePaymentService.class);
	
	public OfflinePayment offlineMode()
	{
		System.out.println("Choose mode of Offlline payment:");
		System.out.println("1.Cash");
		System.out.println("2.Cheque");
		Scanner sc = new Scanner(System.in);
		int option = sc.nextInt();
		OfflinePayment pay = null;
		switch(option)
		{
		case 1:
			
			System.out.println("Enter Receipt Id :");
			String receiptId = sc.next();
			pay=new CashPayment(receiptId);
			break;
			
		case 2:
			
			System.out.println("Enter Bank Name :");
			String bankName = sc.next();
			System.out.println("Enter Cheque Number :");
			String chequeNumber = sc.next();
			pay=new ChequePayment(bankName,chequeNumber);
			break;
		default:
				break;
		}
		
		return pay;
	}

}
