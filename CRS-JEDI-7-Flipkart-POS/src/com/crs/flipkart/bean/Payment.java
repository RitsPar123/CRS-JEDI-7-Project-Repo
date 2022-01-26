/**
 * 
 */
package com.crs.flipkart.bean;

/**
 * @author hardik.kothari
 *
 */
public class Payment {
	private String studentId;
	private	String  paymentId;
	private double amount;
	private String dateOfTransaction;
	private Boolean status;
	private String method;
	/**
	 * @return the method
	 */
	public String getMethod() {
		return method;
	}
	/**
	 * @param method the method to set
	 */
	public void setMethod(String method) {
		this.method = method;
	}
	/**
	 * @return the studentId
	 */
	public String getStudentId() {
		return studentId;
	}
	/**
	 * @param studentId the studentId to set
	 */
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	/**
	 * @return the paymentId
	 */
	public String getPaymentId() {
		return paymentId;
	}
	/**
	 * @param paymentId the paymentId to set
	 */
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}
	/**
	 * @return the dateOfTransaction
	 */
	public String getDateOfTransaction() {
		return dateOfTransaction;
	}
	/**
	 * @param dateOfTransaction the dateOfTransaction to set
	 */
	public void setDateOfTransaction(String dateOfTransaction) {
		this.dateOfTransaction = dateOfTransaction;
	}
	/**
	 * @return the status
	 */
	public Boolean getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	
	
	

}
