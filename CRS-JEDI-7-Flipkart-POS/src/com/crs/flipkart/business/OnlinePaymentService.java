/**
 *
 */
package com.crs.flipkart.business;

import java.util.Scanner;


import com.crs.flipkart.bean.CardPayment;
import com.crs.flipkart.bean.NetBankingPayment;
import com.crs.flipkart.bean.OnlinePayment;
import com.crs.flipkart.bean.UpiPayment;

/**
 * @author hardik.kothari
 *
 */
public class OnlinePaymentService implements OnlinePaymentServiceInterface {


	public OnlinePayment onlineMode()
	{
		System.out.println("Choose mode of payment:");
		System.out.println("1.NetBanking");
		System.out.println("2.UPI");
		System.out.println("3.Card");

		Scanner sc = new Scanner(System.in);
		OnlinePayment pay = null;
		int option = sc.nextInt();
		switch(option)
		{
		case 1:
			System.out.println("Enter IFSC code and Account Number :");
			String ifscCode = sc.next();
			String accountNumber = sc.next();
			pay=new NetBankingPayment(ifscCode, accountNumber);
			break;

		case 2:
			System.out.println("Enter UPI ID :");
			String upiId = sc.next();
			pay=new UpiPayment(upiId);
			break;
		case 3:
			System.out.println("Enter Card Number and Card Type :");
			String cardNumber = sc.next();
			String cardType = sc.next();
			pay=new CardPayment(cardNumber, cardType);
			break;
		default:
			System.out.println("Sorry you entered the wrong choice!!");
				break;
		}
		return pay;

	}

}
