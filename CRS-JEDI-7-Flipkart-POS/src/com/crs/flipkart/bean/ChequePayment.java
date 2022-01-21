/**
 * 
 */
package com.crs.flipkart.bean;

/**
 * @author hardik.kothari
 *
 */
public class ChequePayment extends OfflinePayment{
	
	private String bankName;
	private String chequeNumber;
	
	
	
	/**
	 * @param bankName
	 * @param chequeNumber
	 */
	public ChequePayment(String bankName, String chequeNumber) {
		super();
		this.bankName = bankName;
		this.chequeNumber = chequeNumber;
	}
	/**
	 * @return the bankName
	 */
	public String getBankName() {
		return bankName;
	}
	/**
	 * @param bankName the bankName to set
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	/**
	 * @return the chequeNumber
	 */
	public String getChequeNumber() {
		return chequeNumber;
	}
	/**
	 * @param chequeNumber the chequeNumber to set
	 */
	public void setChequeNumber(String chequeNumber) {
		this.chequeNumber = chequeNumber;
	}
	
	

}
