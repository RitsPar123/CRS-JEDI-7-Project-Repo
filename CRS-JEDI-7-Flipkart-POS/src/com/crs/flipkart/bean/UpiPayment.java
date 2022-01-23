/**
 * 
 */
package com.crs.flipkart.bean;

/**
 * @author hardik.kothari
 *
 */
public class UpiPayment extends OnlinePayment{
	private String upiId;

	/**
	 * @return the upiId
	 */
	
	public UpiPayment(String upiId) {
		super();
		this.upiId = upiId;
	}
	 
	public String getUpiId() {
		return upiId;
	}

	

	/**
	 * @param upiId the upiId to set
	 */
	public void setUpiId(String upiId) {
		this.upiId = upiId;
	}
	
}
