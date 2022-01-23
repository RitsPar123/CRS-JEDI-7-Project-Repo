/**
 * 
 */
package com.crs.flipkart.bean;

/**
 * @author hardik.kothari
 *
 */
public class NetBankingPayment extends OnlinePayment {
	private String ifscCode;
	private String accountNumber;
	public NetBankingPayment(String ifscCode, String accountNumber) {
		// TODO Auto-generated constructor stub
		super();
		this.ifscCode=ifscCode;
		this.accountNumber=accountNumber;
		
	}

	/**
	 * @return the ifscCode
	 */
	
	
	
	public String getIfscCode() {
		return ifscCode;
	}
	
	/**
	 * @param ifscCode the ifscCode to set
	 */
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	/**
	 * @return the accountNumber
	 */
	public String getAccountNumber() {
		return accountNumber;
	}
	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
}
