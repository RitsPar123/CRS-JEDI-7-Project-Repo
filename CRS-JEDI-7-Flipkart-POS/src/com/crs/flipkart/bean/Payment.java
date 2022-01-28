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
	private String paymentMethod;
	private double amount;
	private String dateOfTransaction;
	private Boolean status;
	/**
	 * @return the method
	 */
	
	/**
	 * Parameterized constructor
	 * @param Id: student id in the database
	 * @param paymentId: payment id of the student
	 * @param method: type of payment
	 * @param amount: amount for the payment
	 * @param dateT: reference date for the payment
	 * @param status: status for the payment
	 */
	
	public Payment(String Id,String paymentId,String method,double amount,String dateT,Boolean status){
		this.studentId = Id;
		this.paymentId = paymentId;
		this.paymentMethod = method;
		this.amount = amount;
		this.dateOfTransaction = dateT;
		this.status = status;
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
	
	/**
	 * Method to get type of Payment
	 * @return Student Id
	 */
	public String getPaymentMethod() {
		return paymentMethod;
	}

	/**
	 * @param paymentMethod is set
	 */
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

}
