/**
 * 
 */
package com.crs.flipkart.bean;

/**
 * @author hardik.kothari
 *
 */
public class CashPayment extends OfflinePayment{
	
	private String receiptId;
	
	

	/**
	 * @param receiptId
	 */
	public CashPayment(String receiptId) {
		super();
		this.receiptId = receiptId;
	}

	/**
	 * @return the receiptId
	 */
	public String getReceiptId() {
		return receiptId;
	}

	/**
	 * @param receiptId the receiptId to set
	 */
	public void setReceiptId(String receiptId) {
		this.receiptId = receiptId;
	}

	

}
